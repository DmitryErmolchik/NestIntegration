package com.dim4tech.nest.endpoint;

public enum Endpoint {
    ROOT(""),
    DEVICES("devices"),
    DEVICES_THERMOSTATS(DEVICES, "thermostats"),
    DEVICES_SMOKE_CO_ALARMS(DEVICES, "smoke_co_alarms"),
    DEVICES_CAMERAS(DEVICES, "cameras"),
    STRUCTURES("structures");

    private final Endpoint parentEndpoint;
    private final String path;

    Endpoint(String path) {
        this(null, path);
    }

    Endpoint(Endpoint parentEndpoint, String path) {
        this.parentEndpoint = parentEndpoint;
        this.path = path;
    }

    public String getPath() {
        StringBuilder pathBuilder = new StringBuilder();
        if (this.parentEndpoint != null) {
            pathBuilder.append(this.getPath()).append("/");
        }
        return pathBuilder.append(path).toString();
    }
}
