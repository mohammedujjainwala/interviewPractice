package cacheSystem.factory;

import cacheSystem.evictionpolicies.FIFOEvictionPolicy;
import cacheSystem.services.CacheService;
import cacheSystem.services.ICacheService;
import cacheSystem.storage.InternalStorage;

import java.util.HashMap;

public class CacheFactory<Key, Value> implements ICacheFactory<Key, Value> {
    public ICacheService<Key, Value> defaultCache(int capacity){
        return new CacheService<Key, Value>(new FIFOEvictionPolicy<Key>(), new InternalStorage<Key, Value>(capacity, new HashMap<>()));
    }

    @Override
    public ICacheService<Key, Value> optimisedCache(final int capacity, final int cost) {
        return null;
    }
}
