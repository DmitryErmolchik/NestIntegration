package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.constant.Default;
import com.dim4tech.nest.domain.payload.DeviceId;
import com.dim4tech.nest.utils.Endpoints;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SmokeCoAlarmLoaderTest {
    private final static String accessToken = "c.KzH5UIETsHENeKfWoXHRV7wZLKwgofmqx3RFV53qJ7ZYXpiH18aYKptfekCzmNQAMCVu3RnipfrmcqFMZL8ruuMKcvlMgBVvkoCUMRxMeRJjiLZMH3HJWWbO793EEA5tSR7E4J3VA0CG66as";
    private final SmokeCoAlarmLoader loader;
    private final String HOST_URL = "http://localhost";
    private final int SERVER_PORT = 8000;
    private final String CHARSET = Default.CHARSET;

    private final String DATA = "{  \n" +
            " \"device_id\": \"RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs\",\n" +
            " \"locale\": \"en-US\",\n" +
            " \"software_version\": \"1.01\",\n" +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
            " \"name\": \"Hallway (upstairs)\",\n" +
            " \"name_long\": \"Hallway Protect (upstairs)\",\n" +
            " \"last_connection\": \"2016-10-31T23:59:59.000Z\",\n" +
            " \"is_online\": true,\n" +
            " \"battery_health\": \"ok\",\n" +
            " \"co_alarm_state\": \"ok\",\n" +
            " \"smoke_alarm_state\": \"ok\",\n" +
            " \"is_manual_test_active\": true,\n" +
            " \"last_manual_test_time\": \"2016-10-31T23:59:59.000Z\",\n" +
            " \"ui_color_state\": \"gray\",\n" +
            " \"where_id\": \"UNCBGUnN24...\"\n" +
            "}";
    private HttpServer httpServer;

    public SmokeCoAlarmLoaderTest() throws MalformedURLException {
        loader = new SmokeCoAlarmLoader(new Endpoints(new URL(HOST_URL + ":" + SERVER_PORT)).getSmokeCoAlarm(new DeviceId("RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs")));
    }

    @Test
    public void load() throws Exception {
        try {
            startSimpleServer();
            assertEquals(ExpectedObjectsBuilder.buildExpectedSmokeCoAlarm(), loader.load(accessToken));
        }
        finally {
            stopSimpleServer();
        }
    }

    private void startSimpleServer() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
            httpServer.createContext("/devices/smoke_co_alarms/RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs", httpExchange -> {
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