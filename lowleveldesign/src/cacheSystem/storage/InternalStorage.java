package cacheSystem.storage;

import cacheSystem.exception.CacheFullException;
import cacheSystem.exception.KeyNotFoundException;

import java.util.Map;

public class InternalStorage<Key, Value> implements IStorage<Key, Value> {
    private Map<Key, Value> store;
    private int capacity;
    public InternalStorage(int capacity, Map<Key, Value> store){
        this.store = store;
        this.capacity = capacity;
    }

    @Override
    public void add(Key key, Value value) {
        if(!store.containsKey(key) && store.size() >= capacity){
            throw new CacheFullException();
        }
        store.put(key, value);
    }

    @Override
    public void remove(Key key) {
        if(!store.containsKey(key)){
            throw new KeyNotFoundException();
        }
        store.remove(key);
    }

    @Override
    public Value get(Key key) {
        if(!store.containsKey(key)){
            throw new KeyNotFoundException();
        }
        return store.get(key);
    }

    @Override
    public double getUsage() {
        return (store.size()*100.0)/capacity;
    }
}
