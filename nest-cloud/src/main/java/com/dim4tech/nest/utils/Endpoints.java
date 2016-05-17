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
        try {
            return new URL(rootPath, Endpoint.DEVICES.getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NestIntegrationException();
        }
    }

    public URL getThermostats() {
        try {
            return new URL(rootPath, Endpoint.STRUCTURES.getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NestIntegrationException();
        }
    }

    public URL getSmokeCoAlarms() {
        return null;
    }

    public URL getCameras() {
        return null;
    }

    public URL getStructures() {
        return null;
    }
}
