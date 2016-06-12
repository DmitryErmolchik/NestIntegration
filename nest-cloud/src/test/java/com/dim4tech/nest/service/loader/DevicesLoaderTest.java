package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.constant.Default;
import com.dim4tech.nest.utils.Endpoints;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class DevicesLoaderTest {
    private final static String accessToken = "c.KzH5UIETsHENeKfWoXHRV7wZLKwgofmqx3RFV53qJ7ZYXpiH18aYKptfekCzmNQAMCVu3RnipfrmcqFMZL8ruuMKcvlMgBVvkoCUMRxMeRJjiLZMH3HJWWbO793EEA5tSR7E4J3VA0CG66as";
    private final DevicesLoader devicesLoader;
    private final String HOST_URL = "http://localhost";
    private final int SERVER_PORT = 8000;
    private final String CHARSET = Default.CHARSET;

    private final String DATA = "{  \n" +
            "\"thermostats\": {  \n" +
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
            "},\n" +
            "\"smoke_co_alarms\": {  \n" +
            "\"RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs\": {  \n" +
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
            "}\n" +
            "},\n" +
            "\"cameras\": {  \n" +
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
            "},\n" +
            "\"$company\": {  \n" +
            "\"$product_type\": {  \n" +
            "\"CPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg\": {  \n" +
            "\"identification\": {  \n" +
            " \"device_id\": \"CPMEMSnC48JlSAHjQIp-kHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg\",\n" +
            " \"serial_number\": \"1L090B50230\"\n" +
            "},\n" +
            "\"location\": {  \n" +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
            " \"where_id\": \"UNCBGUnN24...\"\n" +
            "},\n" +
            "\"software\": {  \n" +
            " \"version\": \"1.0\"\n" +
            "},\n" +
            "\"resource_use\": {  \n" +
            "\"electricity\": {  \n" +
            " \"value\": 42.789,\n" +
            " \"measurement_reset_time\": \"2016-01-01T01:01:01.000Z\",\n" +
            " \"measurement_time\": \"2016-01-01T01:02:35.000Z\"\n" +
            "},\n" +
            "\"gas\": {  \n" +
            " \"value\": 0.345234545,\n" +
            " \"measurement_reset_time\": \"2016-01-01T01:01:01.000Z\",\n" +
            " \"measurement_time\": \"2016-01-01T01:02:35.000Z\"\n" +
            "},\n" +
            "\"water\": {  \n" +
            " \"value\": 10000.3,\n" +
            " \"measurement_reset_time\": \"2016-01-01T01:01:01.000Z\",\n" +
            " \"measurement_time\": \"2016-01-01T01:02:35.000Z\"\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "}";

    private HttpServer httpServer;

    public DevicesLoaderTest() throws MalformedURLException {
        devicesLoader = new DevicesLoader(new Endpoints(new URL(HOST_URL + ":" + SERVER_PORT)));
    }

    @Test
    public void load() throws Exception {
        try {
            startSimpleServer();
            assertEquals(ExpectedObjectsBuilder.buildExpectedDevices(), devicesLoader.load(accessToken));
        }
        finally {
            stopSimpleServer();
        }
    }

    private void startSimpleServer() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
            httpServer.createContext("/devices", httpExchange -> {
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