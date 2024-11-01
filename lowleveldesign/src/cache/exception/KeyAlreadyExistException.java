package cache.exception;

public class KeyAlreadyExistException extends RuntimeException{
    public KeyAlreadyExistException(){
        super("Key already exist");
    }
}
