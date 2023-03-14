package Another.one.Main;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AnotherRestRepository extends JpaRepository<AnotherRestEntity,Long> {

}
