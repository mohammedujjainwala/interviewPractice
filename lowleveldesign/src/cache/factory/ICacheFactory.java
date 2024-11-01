package cache.factory;


import cache.services.ICacheService;

public interface ICacheFactory<Key, Value> {
    ICacheService<Key, Value> defaultCache(int capacity);
}
