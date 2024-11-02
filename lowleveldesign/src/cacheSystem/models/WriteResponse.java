package cacheSystem.models;

public class WriteResponse {
    private final double responseTime;

    public WriteResponse(final double responseTime) {
        this.responseTime = responseTime;
    }

    public double getResponseTime() {
        return responseTime;
    }
}
