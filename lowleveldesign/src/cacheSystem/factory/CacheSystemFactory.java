package cacheSystem.factory;

import cacheSystem.cachelevel.CacheLevel;
import cacheSystem.cachelevel.ICacheLevel;
import cacheSystem.cachelevel.NullEffectiveCacheLevel;
import cacheSystem.common.CacheSystemStats;
import cacheSystem.models.CacheLevelConfig;
import cacheSystem.services.CacheSystemService;
import cacheSystem.services.ICacheSystemService;

public class CacheSystemFactory <Key, Value> implements ICacheSystemFactory<Key, Value>{

    private final ICacheFactory<Key, Value> cacheFactory;

    public CacheSystemFactory(final ICacheFactory<Key, Value> cacheFactory) {
        this.cacheFactory = cacheFactory;
    }

    @Override
    public ICacheSystemService<Key, Value> defaultCacheSystem(final int numLevels) {
        ICacheLevel<Key, Value> cacheLevel = new NullEffectiveCacheLevel<>();
        for(int i=numLevels;i>0;i--){
            cacheLevel = new CacheLevel<>("L"+i, cacheFactory.defaultCache(10),
                                                                     new CacheLevelConfig(1,2),cacheLevel);
        }
        return new CacheSystemService<>(cacheLevel, new CacheSystemStats<>(10, cacheLevel));
    }

    @Override
    public ICacheSystemService<Key, Value> optimisedCacheSystem(final int totalCost, final int numLevels) {
        return null;
    }

    @Override
    public ICacheSystemService<Key, Value> readOptimisedCacheSystem(final int totalCost, final int numLevels,
                                                                    final int avgReadTime) {
        return null;
    }
}
