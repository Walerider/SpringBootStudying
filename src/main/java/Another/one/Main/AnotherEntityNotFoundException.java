package Another.one.Main;

public class AnotherEntityNotFoundException extends RuntimeException{
    public AnotherEntityNotFoundException(Long id) {
        super("Could not find entity " + id);
    }
}
