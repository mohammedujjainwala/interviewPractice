package cache.factory;

import cache.evictionpolicies.FIFOEvictionPolicy;
import cache.services.CacheService;
import cache.services.ICacheService;
import cache.storage.InternalStorage;

import java.util.HashMap;

public class CacheFactory<Key, Value> implements ICacheFactory<Key, Value>{
    public ICacheService<Key, Value> defaultCache(int capacity){
        return new CacheService<Key, Value>(new FIFOEvictionPolicy<Key>(), new InternalStorage<Key, Value>(capacity, new HashMap<>()));
    }
}
