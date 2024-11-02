package cacheSystem.common;

import cacheSystem.models.CacheSystemStatsResponse;
import cacheSystem.models.ReadResponse;
import cacheSystem.models.WriteResponse;

public interface ICacheSystemStats<Key, Value> {
    void updateStats(ReadResponse<Value> readResponse);
    void updateStats(WriteResponse writeResponse);
    CacheSystemStatsResponse getStats();
}
