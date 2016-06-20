package com.dim4tech.nest.utils;

import com.dim4tech.nest.domain.payload.DeviceId;
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
        assertEquals(baseUrl, endpoints.getNestData().toString());
    }

    @Test
    public void getDevices() throws Exception {
        assertEquals(baseUrl + "devices", endpoints.getDevices().toString());
    }

    @Test
    public void getThermostats() throws Exception {
        assertEquals(baseUrl + "devices/thermostats", endpoints.getThermostats().toString());
    }

    @Test
    public void getThermostat() throws Exception {
        assertEquals(baseUrl + "devices/thermostats/123", endpoints.getThermostat(new DeviceId("123")).toString());
    }

    @Test
    public void getSmokeCoAlarms() throws Exception {
        assertEquals(baseUrl + "devices/smoke_co_alarms", endpoints.getSmokeCoAlarms().toString());
    }

    @Test
    public void getSmokeCoAlarm() throws Exception {
        assertEquals(baseUrl + "devices/smoke_co_alarms/123", endpoints.getSmokeCoAlarm(new DeviceId("123")).toString());
    }

    @Test
    public void getCameras() throws Exception {
        assertEquals(baseUrl + "devices/cameras", endpoints.getCameras().toString());
    }

    @Test
    public void getCamera() throws Exception {
        assertEquals(baseUrl + "devices/cameras/123", endpoints.getCamera(new DeviceId("123")).toString());
    }

    @Test
    public void getCompany() throws Exception {
        assertEquals(baseUrl + "devices/$company", endpoints.getCompany("$company").toString());
    }

    @Test
    public void getStructures() throws Exception {
        assertEquals(baseUrl + "structures", endpoints.getStructures().toString());
    }

    @Test
    public void getStructure() throws Exception {
        assertEquals(baseUrl + "structures/123", endpoints.getStructure(new StructureId("123")).toString());
    }

    @Test
    public void getMetadata() throws Exception {
        assertEquals(baseUrl + "metadata", endpoints.getMetadata().toString());
    }
}