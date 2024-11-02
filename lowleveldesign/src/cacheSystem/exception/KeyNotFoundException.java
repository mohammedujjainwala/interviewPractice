package cacheSystem.exception;

public class KeyNotFoundException extends RuntimeException{
    public KeyNotFoundException(){
        super("Key not found exception");
    }
}
