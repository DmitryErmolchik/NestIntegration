package com.dim4tech.nest.utils;

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
    public void getDevices() throws Exception {
        assertEquals(baseUrl + "devices", endpoints.getDevices().toString());
    }

    @Test
    public void getThermostats() throws Exception {
        assertEquals(baseUrl + "devices/thermostats", endpoints.getThermostats().toString());
    }

    @Test
    public void getSmokeCoAlarms() throws Exception {
        assertEquals(baseUrl + "devices/smoke_co_alarms", endpoints.getSmokeCoAlarms().toString());
    }

    @Test
    public void getCameras() throws Exception {
        assertEquals(baseUrl + "devices/cameras", endpoints.getCameras().toString());
    }

    @Test
    public void getStructures() throws Exception {
        assertEquals(baseUrl + "structures", endpoints.getStructures().toString());
    }
}