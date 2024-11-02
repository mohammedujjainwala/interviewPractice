package cacheSystem.models;

public class CacheLevelConfig {
    private double readTime;
    private double writeTime;

    public CacheLevelConfig(final double readTime, final double writeTime) {
        this.readTime = readTime;
        this.writeTime = writeTime;
    }

    public double getReadTime() {
        return readTime;
    }

    public double getWriteTime() {
        return writeTime;
    }
}
