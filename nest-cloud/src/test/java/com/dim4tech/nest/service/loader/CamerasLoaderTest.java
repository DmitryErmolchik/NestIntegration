package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.constant.Default;
import com.dim4tech.nest.domain.payload.Camera;
import com.dim4tech.nest.domain.payload.DeviceId;
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

public class CamerasLoaderTest {
    private final static String accessToken = "c.KzH5UIETsHENeKfWoXHRV7wZLKwgofmqx3RFV53qJ7ZYXpiH18aYKptfekCzmNQAMCVu3RnipfrmcqFMZL8ruuMKcvlMgBVvkoCUMRxMeRJjiLZMH3HJWWbO793EEA5tSR7E4J3VA0CG66as";
    private final CamerasLoader loader;
    private final String HOST_URL = "http://localhost";
    private final int SERVER_PORT = 8000;
    private final String CHARSET = Default.CHARSET;

    private final String DATA = "{  \n" +
            "\"awJo6rH0IldT2YlIVtYaGQ\": {  \n" +
            " \"device_id\": \"awJo6rH0IldT2YlIVtYaGQ\",\n" +
            " \"software_version\": \"4.0\",\n" +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
            " \"where_id\": \"d6reb_OZTM...\",\n" +
            " \"name\": \"Hallway (upstairs)\",\n" +
            " \"name_long\": \"Hallway Camera (upstairs)\",\n" +
            " \"is_online\": true,\n" +
            " \"is_streaming\": true,\n" +
            " \"is_audio_input_enabled\": true,\n" +
            " \"last_is_online_change\": \"2016-12-29T18:42:00.000Z\",\n" +
            " \"is_video_history_enabled\": true,\n" +
            " \"web_url\": \"https://home.nest.com/cameras/device_id?auth=access_token\",\n" +
            " \"app_url\": \"nestmobile://cameras/device_id?auth=access_token\",\n" +
            " \"is_public_share_enabled\": true,\n" +
            " \"activity_zones\": [ { \"name\": \"Walkway 1\", \"id\": \"244083\" }, { \"name\": \"Walkway 2\", \"id\": \"244084\" }, { \"name\": \"Walkway 3\", \"id\": \"244085\" } ],\n" +
            " \"public_share_url\": \"https://video.nest.com/live/STRING1?STRING2\",\n" +
            " \"snapshot_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
            "\"last_event\": {  \n" +
            " \"has_sound\": true,\n" +
            " \"has_motion\": true,\n" +
            " \"start_time\": \"2016-12-29T00:00:00.000Z\",\n" +
            " \"end_time\": \"2016-12-29T18:42:00.000Z\",\n" +
            " \"urls_expire_time\": \"2016-10-31T23:59:59.000Z\",\n" +
            " \"web_url\": \"https://home.nest.com/cameras/device_id/cuepoints/STRING?auth=access_token\",\n" +
            " \"app_url\": \"nestmobile://cameras/device_id/cuepoints/STRING?auth=access_token\",\n" +
            " \"image_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
            " \"animated_image_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
            " \"activity_zone_ids\": [ \"244083\", \"244084\", \"244085\" ]\n" +
            "}\n" +
            "}\n" +
            "}";
    private HttpServer httpServer;

    public CamerasLoaderTest() throws MalformedURLException {
        loader = new CamerasLoader(new Endpoints(new URL(HOST_URL + ":" + SERVER_PORT)).getCamerasUrl());
    }

    @Test
    public void load() throws Exception {
        try {
            startSimpleServer();
            Map<DeviceId, Camera> expected = new HashMap<>();
            Camera camera = ExpectedObjectsBuilder.buildExpectedCamera();
            expected.put(camera.getDeviceId(), camera);
            assertEquals(expected, loader.load(accessToken));
        }
        finally {
            stopSimpleServer();
        }
    }

    private void startSimpleServer() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
            httpServer.createContext("/devices/cameras", httpExchange -> {
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