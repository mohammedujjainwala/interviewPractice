package cacheSystem.cachelevel;

import cacheSystem.exception.KeyNotFoundException;
import cacheSystem.models.CacheLevelConfig;
import cacheSystem.models.CacheLeveLStats;
import cacheSystem.models.ReadResponse;
import cacheSystem.models.WriteResponse;
import cacheSystem.services.ICacheService;

import java.util.List;

public class CacheLevel<Key, Value> implements ICacheLevel<Key, Value> {

    private final String level;
    private final ICacheService<Key, Value> cacheService;
    private final CacheLevelConfig cacheLevelConfig;
    private final ICacheLevel<Key, Value> next;
    public CacheLevel(final String level, final ICacheService<Key, Value> cacheService,
                      final CacheLevelConfig cacheLevelConfig,
                      final ICacheLevel<Key, Value> next) {
        this.level = level;
        this.cacheService = cacheService;
        this.cacheLevelConfig = cacheLevelConfig;
        this.next = next;
    }

    @Override
    public WriteResponse add(final Key key, final Value value) {
        double timeTaken = cacheLevelConfig.getReadTime();
        try {
            if (cacheService.get(key) != value) {
                cacheService.add(key, value);
                timeTaken += cacheLevelConfig.getWriteTime();
            }
        }catch (KeyNotFoundException keyNotFoundException){
            cacheService.add(key, value);
            timeTaken += cacheLevelConfig.getWriteTime();
        }
        timeTaken += next.add(key, value).getResponseTime();
        return new WriteResponse(timeTaken);
    }

    @Override
    public ReadResponse<Value> get(final Key key) {
        double timeTaken = cacheLevelConfig.getReadTime();
        try {
            Value value = cacheService.get(key);
            return new ReadResponse<Value>(value, timeTaken);
        }catch (KeyNotFoundException keyNotFoundException){
            final ReadResponse<Value> readResponse = next.get(key);
            timeTaken += readResponse.getResponseTime();
            if (readResponse.getValue() != null) {
                cacheService.add(key, readResponse.getValue());
                timeTaken += cacheLevelConfig.getWriteTime();
            }
            return new ReadResponse<>(readResponse.getValue(), timeTaken);
        }
    }

    @Override
    public List<CacheLeveLStats> getStats() {
        List<CacheLeveLStats> stats = next.getStats();
        stats.add(new CacheLeveLStats(level, cacheService.getUsage()));
        return stats;
    }
}
