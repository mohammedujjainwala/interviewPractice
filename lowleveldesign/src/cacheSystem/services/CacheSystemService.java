package cacheSystem.services;

import cacheSystem.cachelevel.ICacheLevel;
import cacheSystem.common.CacheSystemStats;
import cacheSystem.common.ICacheSystemStats;
import cacheSystem.models.CacheSystemStatsResponse;
import cacheSystem.models.ReadResponse;
import cacheSystem.models.WriteResponse;

public class CacheSystemService<Key, Value> implements ICacheSystemService<Key, Value>{

    private ICacheLevel<Key, Value> cacheLevel;
    private ICacheSystemStats<Key, Value> stats; //This can be injected

    public CacheSystemService(final ICacheLevel<Key, Value> cacheLevel, CacheSystemStats<Key, Value> stats) {
        this.cacheLevel = cacheLevel;
        this.stats = stats;
    }

    @Override
    public WriteResponse add(final Key key, final Value value) {
        final WriteResponse writeResponse = cacheLevel.add(key, value);
        stats.updateStats(writeResponse);
        return writeResponse;
    }

    @Override
    public ReadResponse<Value> get(final Key key) {
        final ReadResponse<Value> readResponse = cacheLevel.get(key);
        stats.updateStats(readResponse);
        return readResponse;
    }

    @Override
    public CacheSystemStatsResponse getStats() {
        return stats.getStats();
    }
}
