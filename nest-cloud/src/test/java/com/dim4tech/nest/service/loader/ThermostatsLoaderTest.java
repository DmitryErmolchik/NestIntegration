package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.constant.Default;
import com.dim4tech.nest.domain.payload.DeviceId;
import com.dim4tech.nest.domain.payload.Thermostat;
import com.dim4tech.nest.utils.Endpoints;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ThermostatsLoaderTest {
    private final static String accessToken = "c.KzH5UIETsHENeKfWoXHRV7wZLKwgofmqx3RFV53qJ7ZYXpiH18aYKptfekCzmNQAMCVu3RnipfrmcqFMZL8ruuMKcvlMgBVvkoCUMRxMeRJjiLZMH3HJWWbO793EEA5tSR7E4J3VA0CG66as";
    private final ThermostatsLoader loader;
    private final String HOST_URL = "http://localhost";
    private final int SERVER_PORT = 8000;
    private final String CHARSET = Default.CHARSET;

    private final String DATA = "{  \n" +
            "\"peyiJNo0IldT2YlIVtYaGQ\": {  \n" +
            " \"device_id\": \"peyiJNo0IldT2YlIVtYaGQ\",\n" +
            " \"locale\": \"en-US\",\n" +
            " \"software_version\": \"4.0\",\n" +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
            " \"name\": \"Hallway (upstairs)\",\n" +
            " \"name_long\": \"Hallway Thermostat (upstairs)\",\n" +
            " \"last_connection\": \"2016-10-31T23:59:59.000Z\",\n" +
            " \"is_online\": true,\n" +
            " \"can_cool\": true,\n" +
            " \"can_heat\": true,\n" +
            " \"is_using_emergency_heat\": true,\n" +
            " \"has_fan\": true,\n" +
            " \"fan_timer_active\": true,\n" +
            " \"fan_timer_timeout\": \"2016-10-31T23:59:59.000Z\",\n" +
            " \"has_leaf\": true,\n" +
            " \"temperature_scale\": \"C\",\n" +
            " \"target_temperature_f\": 72,\n" +
            " \"target_temperature_c\": 21.5,\n" +
            " \"target_temperature_high_f\": 72,\n" +
            " \"target_temperature_high_c\": 21.5,\n" +
            " \"target_temperature_low_f\": 64,\n" +
            " \"target_temperature_low_c\": 17.5,\n" +
            " \"away_temperature_high_f\": 72,\n" +
            " \"away_temperature_high_c\": 21.5,\n" +
            " \"away_temperature_low_f\": 64,\n" +
            " \"away_temperature_low_c\": 17.5,\n" +
            " \"hvac_mode\": \"heat\",\n" +
            " \"ambient_temperature_f\": 72,\n" +
            " \"ambient_temperature_c\": 21.5,\n" +
            " \"humidity\": 40,\n" +
            " \"hvac_state\": \"heating\",\n" +
            " \"where_id\": \"UNCBGUnN24...\",\n" +
            " \"is_locked\": true,\n" +
            " \"locked_temp_min_f\": \"65\",\n" +
            " \"locked_temp_max_f\": \"80\",\n" +
            " \"locked_temp_min_c\": \"19.5\",\n" +
            " \"locked_temp_max_c\": \"24.5\",\n" +
            " \"label\": \"upstairs\"\n" +
            "}\n" +
            "}";

    private HttpServer httpServer;

    public ThermostatsLoaderTest() throws MalformedURLException {
        loader = new ThermostatsLoader(new Endpoints(new URL(HOST_URL + ":" + SERVER_PORT)).getThermostatsUrl());
    }

    @Test
    public void load() throws Exception {
        try {
            startSimpleServer();
            Map<DeviceId, Thermostat> expected = new HashMap<>();
            Thermostat thermostat = ExpectedObjectsBuilder.buildExpectedThermostat();
            expected.put(thermostat.getDeviceId(), thermostat);
            assertEquals(expected, loader.load(accessToken));
        }
        finally {
            stopSimpleServer();
        }
    }

    private void startSimpleServer() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
            httpServer.createContext("/devices/thermostats", httpExchange -> {
                String response = DATA;
                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(response.getBytes(CHARSET));
                outputStream.close();
            });
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopSimpleServer() {
        httpServer.stop(5);
    }
}