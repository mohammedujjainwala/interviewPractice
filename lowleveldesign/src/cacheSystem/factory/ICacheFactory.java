package cacheSystem.factory;


import cacheSystem.services.ICacheService;

public interface ICacheFactory<Key, Value> {
    ICacheService<Key, Value> defaultCache(int capacity);
    ICacheService<Key, Value> optimisedCache(int capacity, int cost); //best fit
}
