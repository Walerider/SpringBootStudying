package Another.one.Main;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntityRestController {
    private final AnotherRestRepository repository;

    public EntityRestController(AnotherRestRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/entitys")
    List<AnotherRestEntity> all(){
        return repository.findAll();
    }
    @PostMapping("/entitys")
    @RequestMapping()
    AnotherRestEntity newEntity(@RequestBody AnotherRestEntity newEntity){
        return repository.save(newEntity);
    }
    @GetMapping("/entitys/{id}")
    AnotherRestEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AnotherEntityNotFoundException(id));
    }

    @PutMapping("/entitys/{id}")
    AnotherRestEntity replaceEntity(@RequestBody AnotherRestEntity newEntity, @PathVariable Long id) {

        return repository.findById(id)
                .map(entity -> {
                    entity.setName(newEntity.getName());
                    entity.setAddress(newEntity.getAddress());
                    return repository.save(entity);
                })
                .orElseGet(() -> {
                    newEntity.setId(id);
                    return repository.save(newEntity);
                });
    }

    @DeleteMapping("/entitys/{id}")
    void deleteEntity(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
