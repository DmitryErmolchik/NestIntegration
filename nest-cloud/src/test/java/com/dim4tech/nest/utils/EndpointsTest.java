package com.dim4tech.nest.utils;

import com.dim4tech.nest.domain.payload.DeviceId;
import com.dim4tech.nest.domain.payload.ProductTypeId;
import com.dim4tech.nest.domain.payload.StructureId;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class EndpointsTest {
    private final Endpoints endpoints;
    private final String baseUrl = "http://www.example.com/";

    public EndpointsTest() throws MalformedURLException {
        endpoints = new Endpoints(new URL(baseUrl));
    }

    @Test
    public void getNestData() throws Exception {
        assertEquals(baseUrl, endpoints.getNestDataUrl().toString());
    }

    @Test
    public void getDevices() throws Exception {
        assertEquals(baseUrl + "devices", endpoints.getDevicesUrl().toString());
    }

    @Test
    public void getThermostats() throws Exception {
        assertEquals(baseUrl + "devices/thermostats", endpoints.getThermostatsUrl().toString());
    }

    @Test
    public void getThermostat() throws Exception {
        assertEquals(baseUrl + "devices/thermostats/123", endpoints.getThermostatUrl(new DeviceId("123")).toString());
    }

    @Test
    public void getSmokeCoAlarms() throws Exception {
        assertEquals(baseUrl + "devices/smoke_co_alarms", endpoints.getSmokeCoAlarmsUrl().toString());
    }

    @Test
    public void getSmokeCoAlarm() throws Exception {
        assertEquals(baseUrl + "devices/smoke_co_alarms/123", endpoints.getSmokeCoAlarmUrl(new DeviceId("123")).toString());
    }

    @Test
    public void getCameras() throws Exception {
        assertEquals(baseUrl + "devices/cameras", endpoints.getCamerasUrl().toString());
    }

    @Test
    public void getCamera() throws Exception {
        assertEquals(baseUrl + "devices/cameras/123", endpoints.getCameraUrl(new DeviceId("123")).toString());
    }

    @Test
    public void getCompany() throws Exception {
        assertEquals(baseUrl + "devices/$company", endpoints.getCompanyUrl("$company").toString());
    }

    @Test
    public void getCompanyProductTypesUrl() throws Exception {
        assertEquals(baseUrl + "devices/$company/$product_type", endpoints.getCompanyProductTypesUrl("$company", "$product_type").toString());
    }

    @Test
    public void getCompanyProductDataUrl() throws Exception {
        assertEquals(baseUrl + "devices/$company/$product_type/123", endpoints.getCompanyProductDataUrl("$company", "$product_type", new ProductTypeId("123")).toString());
    }

    @Test
    public void getStructures() throws Exception {
        assertEquals(baseUrl + "structures", endpoints.getStructuresUrl().toString());
    }

    @Test
    public void getStructure() throws Exception {
        assertEquals(baseUrl + "structures/123", endpoints.getStructureUrl(new StructureId("123")).toString());
    }

    @Test
    public void getMetadata() throws Exception {
        assertEquals(baseUrl + "metadata", endpoints.getMetadataUrl().toString());
    }

    @Test
    public void getStructureEtaUrl() throws Exception {
        assertEquals(baseUrl + "structures/123/eta", endpoints.getStructureEtaUrl(new StructureId("123")).toString());
    }
}