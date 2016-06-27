package com.dim4tech.nest.utils;

import com.dim4tech.nest.domain.payload.DeviceId;
import com.dim4tech.nest.domain.payload.ProductTypeId;
import com.dim4tech.nest.domain.payload.StructureId;
import com.dim4tech.nest.endpoint.Endpoint;
import com.dim4tech.nest.exception.NestIntegrationException;

import java.net.MalformedURLException;
import java.net.URL;

public class Endpoints {
    private final String ETA = "eta";
    private final URL rootPath;

    public Endpoints(URL rootPath) {
        this.rootPath = rootPath;
    }

    public URL getNestDataUrl() {
        return rootPath;
    }

    public URL getDevicesUrl() {
        return buildEndpoint(Endpoint.DEVICES);
    }

    public URL getThermostatsUrl() {
        return buildEndpoint(Endpoint.DEVICES_THERMOSTATS);
    }

    public URL getThermostatUrl(String thermostatId) {
        return buildEndpoint(Endpoint.DEVICES_THERMOSTATS, thermostatId);
    }

    public URL getThermostatUrl(DeviceId thermostatId) {
        return getThermostatUrl(thermostatId.getId());
    }

    public URL getSmokeCoAlarmsUrl() {
        return buildEndpoint(Endpoint.DEVICES_SMOKE_CO_ALARMS);
    }

    public URL getSmokeCoAlarmUrl(String smokeCoAlarmId) {
        return buildEndpoint(Endpoint.DEVICES_SMOKE_CO_ALARMS, smokeCoAlarmId);
    }

    public URL getSmokeCoAlarmUrl(DeviceId smokeCoAlarmId) {
        return getSmokeCoAlarmUrl(smokeCoAlarmId.getId());
    }

    public URL getCamerasUrl() {
        return buildEndpoint(Endpoint.DEVICES_CAMERAS);
    }

    public URL getCameraUrl(String cameraId) {
        return buildEndpoint(Endpoint.DEVICES_CAMERAS, cameraId);
    }

    public URL getCameraUrl(DeviceId cameraId) {
        return getCameraUrl(cameraId.getId());
    }

    public URL getCompanyUrl(String company) {
        return buildEndpoint(Endpoint.DEVICES, company);
    }

    public URL getCompanyProductTypesUrl(String company, String productType) {
        return buildEndpoint(Endpoint.DEVICES, company, productType);
    }

    public URL getCompanyProductDataUrl(String company, String productType, String productTypeId) {
        return buildEndpoint(Endpoint.DEVICES, company, productType, productTypeId);
    }

    public URL getCompanyProductDataUrl(String company, String productType, ProductTypeId productTypeId) {
        return getCompanyProductDataUrl(company, productType, productTypeId.getId());
    }

    public URL getStructuresUrl() {
        return buildEndpoint(Endpoint.STRUCTURES);
    }

    public URL getStructureUrl(String structureId) {
        return buildEndpoint(Endpoint.STRUCTURES, structureId);
    }

    public URL getStructureUrl(StructureId structureId) {
        return getStructureUrl(structureId.getId());
    }

    public URL getStructureEtaUrl(String structureId) {
        return buildEndpoint(Endpoint.STRUCTURES, structureId, ETA);
    }

    public URL getStructureEtaUrl(StructureId structureId) {
        return getStructureEtaUrl(structureId.getId());
    }

    public URL getMetadataUrl() {
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

    private URL buildEndpoint(Endpoint parentEndpoint, String... customEndpoints) {
        StringBuilder customEndpointPathBuilder = new StringBuilder();
        for (int i=0; i< customEndpoints.length; i++) {
            customEndpointPathBuilder.append(customEndpoints[i]);
            if (i < customEndpoints.length-1) {
                customEndpointPathBuilder.append("/");
            }
        }
        try {
            return new URL(rootPath, parentEndpoint.getPath() + "/" + customEndpointPathBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NestIntegrationException();
        }
    }
}
