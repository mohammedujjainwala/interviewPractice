package cacheSystem.cachelevel;

import cacheSystem.models.CacheLeveLStats;
import cacheSystem.models.ReadResponse;
import cacheSystem.models.WriteResponse;

import java.util.List;

public interface ICacheLevel<Key, Value> {
    WriteResponse add(Key key, Value value);
    ReadResponse<Value> get(Key key);
    List<CacheLeveLStats> getStats();
}
