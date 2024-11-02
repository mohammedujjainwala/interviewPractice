package cacheSystem.models;


import java.util.List;

public class CacheSystemStatsResponse {
    private double avgReadTime;
    private double avgWriteTime;
    private List<CacheLeveLStats> stats;
    public CacheSystemStatsResponse(final double avgReadTime, final double avgWriteTime,
                                    final List<CacheLeveLStats> stats) {
        this.avgReadTime = avgReadTime;
        this.avgWriteTime = avgWriteTime;
        this.stats = stats;
    }

    public double getAvgReadTime() {
        return avgReadTime;
    }

    public double getAvgWriteTime() {
        return avgWriteTime;
    }

    public List<CacheLeveLStats> getStats() {
        return stats;
    }
}
