package cache.exception;

public class CacheFullException extends RuntimeException{
    public CacheFullException(){
        super("Cache Full!!!");
    }
}
