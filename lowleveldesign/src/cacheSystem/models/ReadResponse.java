package cacheSystem.models;

public class ReadResponse<Value> {
    private final Value value;
    private final double responseTime;

    public ReadResponse(final Value value, final double responseTime) {
        this.value = value;
        this.responseTime = responseTime;
    }

    public Value getValue() {
        return value;
    }

    public double getResponseTime() {
        return responseTime;
    }
}
