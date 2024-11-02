package cacheSystem.factory;

import cacheSystem.services.ICacheSystemService;

public interface ICacheSystemFactory<Key, Value> {
    ICacheSystemService<Key, Value> defaultCacheSystem(int numLevels);
    ICacheSystemService<Key, Value> optimisedCacheSystem(int totalCost, int numLevels);
    ICacheSystemService<Key, Value> readOptimisedCacheSystem(int totalCost, int numLevels, int avgReadTime);
}
