package cacheSystem.common;

import cacheSystem.cachelevel.ICacheLevel;
import cacheSystem.models.CacheSystemStatsResponse;
import cacheSystem.models.ReadResponse;
import cacheSystem.models.WriteResponse;

import java.util.LinkedList;
import java.util.Queue;

public class CacheSystemStats<Key, Value> implements ICacheSystemStats<Key, Value>{

    private double avgReadTime;
    private double avgWriteTime;
    private Queue<Double> readTime;
    private Queue<Double> writeTime;
    private int lastOperationCount;
    private ICacheLevel<Key, Value> cacheLevel;

    public CacheSystemStats(final int lastOperationCount, final ICacheLevel<Key, Value> cacheLevel) {
        this.avgReadTime = 0;
        this.avgWriteTime = 0;
        this.readTime = new LinkedList<>();
        this.writeTime = new LinkedList<>();
        this.lastOperationCount = lastOperationCount;
        this.cacheLevel = cacheLevel;
    }

    @Override
    public void updateStats(final ReadResponse<Value> readResponse) {
        if(readTime.size() >= lastOperationCount){
            Double removeTime = readTime.poll();
            avgReadTime-=(removeTime)/lastOperationCount;
        }
        avgReadTime+=readResponse.getResponseTime()/lastOperationCount;
        readTime.add(readResponse.getResponseTime());
    }

    @Override
    public void updateStats(final WriteResponse writeResponse) {
        if(writeTime.size() >= lastOperationCount){
            Double removeTime = writeTime.poll();
            avgWriteTime-=(removeTime)/lastOperationCount;
        }
        avgWriteTime+=writeResponse.getResponseTime()/lastOperationCount;
        writeTime.add(writeResponse.getResponseTime());
    }

    @Override
    public CacheSystemStatsResponse getStats() {
        return new CacheSystemStatsResponse(avgReadTime, avgWriteTime, cacheLevel.getStats());
    }
}
