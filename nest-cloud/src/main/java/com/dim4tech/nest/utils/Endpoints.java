package com.dim4tech.nest.utils;

import com.dim4tech.nest.endpoint.Endpoint;
import com.dim4tech.nest.exception.NestIntegrationException;

import java.net.MalformedURLException;
import java.net.URL;

public class Endpoints {
    private final URL rootPath;

    public Endpoints(URL rootPath) {
        this.rootPath = rootPath;
    }

    public URL getDevices() {
        return buildEndpoint(Endpoint.DEVICES);
    }

    public URL getThermostats() {
        return buildEndpoint(Endpoint.DEVICES_THERMOSTATS);
    }

    public URL getSmokeCoAlarms() {
        return buildEndpoint(Endpoint.DEVICES_SMOKE_CO_ALARMS);
    }

    public URL getCameras() {
        return buildEndpoint(Endpoint.DEVICES_CAMERAS);
    }

    public URL getStructures() {
        return buildEndpoint(Endpoint.STRUCTURES);
    }

    private URL buildEndpoint(Endpoint endpoint) {
        try {
            return new URL(rootPath, endpoint.getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NestIntegrationException();
        }
    }
}
