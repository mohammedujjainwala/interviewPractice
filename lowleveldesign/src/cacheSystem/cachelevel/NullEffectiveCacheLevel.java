package cacheSystem.cachelevel;

import cacheSystem.models.CacheLeveLStats;
import cacheSystem.models.ReadResponse;
import cacheSystem.models.WriteResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NullEffectiveCacheLevel<Key, Value> implements ICacheLevel<Key, Value>{
    @Override
    public WriteResponse add(final Key key, final Value value) {
        return new WriteResponse(0.0);
    }

    @Override
    public ReadResponse<Value> get(final Key key) {
        return new ReadResponse<>(null, 0.0);
    }

    @Override
    public List<CacheLeveLStats> getStats() {
        return new ArrayList<>();
    }
}
