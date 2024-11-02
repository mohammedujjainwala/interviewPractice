package cacheSystem.services;

import cacheSystem.models.CacheSystemStatsResponse;
import cacheSystem.models.ReadResponse;
import cacheSystem.models.WriteResponse;

public interface ICacheSystemService<Key, Value> {
    WriteResponse add(Key key, Value value);
    ReadResponse<Value> get(Key key);
    CacheSystemStatsResponse getStats();
}
