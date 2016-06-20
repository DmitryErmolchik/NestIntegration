package com.dim4tech.nest.utils;

import com.dim4tech.nest.domain.payload.DeviceId;
import com.dim4tech.nest.domain.payload.StructureId;
import com.dim4tech.nest.endpoint.Endpoint;
import com.dim4tech.nest.exception.NestIntegrationException;

import java.net.MalformedURLException;
import java.net.URL;

public class Endpoints {
    private final URL rootPath;

    public Endpoints(URL rootPath) {
        this.rootPath = rootPath;
    }

    public URL getNestData() {
        return rootPath;
    }

    public URL getDevices() {
        return buildEndpoint(Endpoint.DEVICES);
    }

    public URL getThermostats() {
        return buildEndpoint(Endpoint.DEVICES_THERMOSTATS);
    }

    public URL getThermostat(String thermostatId) {
        return buildEndpoint(Endpoint.DEVICES_THERMOSTATS, thermostatId);
    }

    public URL getThermostat(DeviceId thermostatId) {
        return getThermostat(thermostatId.getId());
    }

    public URL getSmokeCoAlarms() {
        return buildEndpoint(Endpoint.DEVICES_SMOKE_CO_ALARMS);
    }

    public URL getSmokeCoAlarm(String smokeCoAlarmId) {
        return buildEndpoint(Endpoint.DEVICES_SMOKE_CO_ALARMS, smokeCoAlarmId);
    }

    public URL getSmokeCoAlarm(DeviceId smokeCoAlarmId) {
        return getSmokeCoAlarm(smokeCoAlarmId.getId());
    }

    public URL getCameras() {
        return buildEndpoint(Endpoint.DEVICES_CAMERAS);
    }

    public URL getCamera(String cameraId) {
        return buildEndpoint(Endpoint.DEVICES_CAMERAS, cameraId);
    }

    public URL getCamera(DeviceId cameraId) {
        return getCamera(cameraId.getId());
    }

    public URL getCompany(String company) {
        return buildEndpoint(Endpoint.DEVICES, company);
    }

    public URL getStructures() {
        return buildEndpoint(Endpoint.STRUCTURES);
    }

    public URL getStructure(String structureId) {
        return buildEndpoint(Endpoint.STRUCTURES, structureId);
    }

    public URL getStructure(StructureId structureId) {
        return getStructure(structureId.getId());
    }

    public URL getMetadata() {
        return buildEndpoint(Endpoint.METADATA);
    }

    private URL buildEndpoint(Endpoint endpoint) {
        try {
            return new URL(rootPath, endpoint.getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NestIntegrationException();
        }
    }

    private URL buildEndpoint(Endpoint parentEndpoint, String customEndpoint) {
        try {
            return new URL(rootPath, parentEndpoint.getPath() + "/" + customEndpoint);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NestIntegrationException();
        }
    }
}
