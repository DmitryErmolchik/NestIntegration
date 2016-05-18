package com.dim4tech.nest.utils;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class EndpointsTest {
    private final Endpoints endpoints;

    public EndpointsTest() throws MalformedURLException {
        endpoints = new Endpoints(new URL("http://www.example.com/"));
    }

    @Test
    public void getDevices() throws Exception {
        assertEquals("http://www.example.com/devices", endpoints.getDevices().toString());
    }

    @Test
    public void getThermostats() throws Exception {
        assertEquals("http://www.example.com/devices/thermostats", endpoints.getThermostats().toString());
    }

    @Test
    public void getSmokeCoAlarms() throws Exception {
        assertEquals("http://www.example.com/devices/smoke_co_alarms", endpoints.getSmokeCoAlarms().toString());
    }

    @Test
    public void getCameras() throws Exception {
        assertEquals("http://www.example.com/devices/cameras", endpoints.getCameras().toString());
    }

    @Test
    public void getStructures() throws Exception {
        assertEquals("http://www.example.com/structures", endpoints.getStructures().toString());
    }

}