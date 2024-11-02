package cacheSystem.exception;

public class KeyAlreadyExistException extends RuntimeException{
    public KeyAlreadyExistException(){
        super("Key already exist");
    }
}
