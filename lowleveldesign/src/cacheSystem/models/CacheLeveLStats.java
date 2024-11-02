package cacheSystem.models;

public class CacheLeveLStats {
    private String level;
    private double usages;

    public CacheLeveLStats(final String level, final double usages) {
        this.level = level;
        this.usages = usages;
    }

    public String getLevel() {
        return level;
    }

    public double getUsages() {
        return usages;
    }
}
