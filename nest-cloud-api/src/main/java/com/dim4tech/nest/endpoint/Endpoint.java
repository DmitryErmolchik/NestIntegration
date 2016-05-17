package com.dim4tech.nest.endpoint;

public enum Endpoint {
    ROOT(""),
    DEVICES("devices"),
    STRUCTURES("structures");

    private final String path;

    Endpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
