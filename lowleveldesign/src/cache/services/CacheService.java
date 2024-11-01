package cache.services;

import cache.evictionPolicies.IEvictionPolicy;
import cache.exception.CacheFullException;
import cache.storage.IStorage;

public class CacheService<Key, Value> implements ICacheService<Key, Value> {
    private IEvictionPolicy<Key> evictionPolicy;
    private IStorage<Key, Value> storage;
    public CacheService(IEvictionPolicy<Key> IEvictionPolicy, IStorage<Key, Value> IStorage){
        this.evictionPolicy = IEvictionPolicy;
        this.storage = IStorage;
    }

    @Override
    public void add(Key key, Value value) {
        try {
            addKeyValue(key, value);
        }catch (CacheFullException e){
            System.out.println("Storage full while inserting Key:"+key+" Value:"+value);
            Key evictedKey = evictionPolicy.evictKey();
            System.out.println("Evicting key:"+evictedKey);
            storage.remove(evictedKey);
            addKeyValue(key, value);
        }
    }

    private void addKeyValue(Key key, Value value){
        storage.add(key, value);
        evictionPolicy.keyAccessed(key);
    }

    @Override
    public void remove(Key key) {
        storage.remove(key);
        evictionPolicy.removeKey(key);
    }

    @Override
    public Value get(Key key) {
        evictionPolicy.keyAccessed(key);
        return storage.get(key);
    }
}
