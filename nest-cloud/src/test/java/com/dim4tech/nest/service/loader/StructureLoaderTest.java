package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.constant.Default;
import com.dim4tech.nest.domain.payload.StructureId;
import com.dim4tech.nest.utils.Endpoints;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class StructureLoaderTest {
    private final static String accessToken = "c.KzH5UIETsHENeKfWoXHRV7wZLKwgofmqx3RFV53qJ7ZYXpiH18aYKptfekCzmNQAMCVu3RnipfrmcqFMZL8ruuMKcvlMgBVvkoCUMRxMeRJjiLZMH3HJWWbO793EEA5tSR7E4J3VA0CG66as";
    private final StructureLoader loader;
    private final String HOST_URL = "http://localhost";
    private final int SERVER_PORT = 8000;
    private final String CHARSET = Default.CHARSET;

    private final String DATA = "{  \n" +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
            " \"thermostats\": [ \"peyiJNo0IldT2YlIVtYaGQ\", \"qeyiJNo0IldT2YlIVtYaGQ\" ],\n" +
            " \"smoke_co_alarms\": [ \"RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs\", \"STMTKxsQTCxzVcsySOHPxKoF4OyCifrs\" ],\n" +
            " \"cameras\": [ \"awJo6rH...\", \"bwJo6rH...\" ],\n" +
            "\"devices\": {  \n" +
            "\"$company\": {  \n" +
            " \"$product_type\": [ \"CPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg\", \"DPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg\" ]\n" +
            "}\n" +
            "},\n" +
            " \"away\": \"home\",\n" +
            " \"name\": \"Home\",\n" +
            " \"country_code\": \"US\",\n" +
            " \"postal_code\": \"94304\",\n" +
            " \"peak_period_start_time\": \"2016-10-31T23:59:59.000Z\",\n" +
            " \"peak_period_end_time\": \"2016-10-31T23:59:59.000Z\",\n" +
            " \"time_zone\": \"America/Los_Angeles\",\n" +
            "\"eta\": {  \n" +
            " \"trip_id\": \"myTripHome1024\",\n" +
            " \"estimated_arrival_window_begin\": \"2016-10-31T22:42:59.000Z\",\n" +
            " \"estimated_arrival_window_end\": \"2016-10-31T23:59:59.000Z\"\n" +
            "},\n" +
            " \"rhr_enrollment\": true,\n" +
            "\"wheres\": {  \n" +
            "\"Fqp6wJI...\": {  \n" +
            " \"where_id\": \"Fqp6wJI...\",\n" +
            " \"name\": \"Bedroom\"\n" +
            "}\n" +
            "}\n" +
            "}";

    private HttpServer httpServer;

    public StructureLoaderTest() throws MalformedURLException {
        loader = new StructureLoader(new Endpoints(new URL(HOST_URL + ":" + SERVER_PORT)).getStructure(new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw")));
    }

    @Test
    public void load() throws Exception {
        try {
            startSimpleServer();
            assertEquals(ExpectedObjectsBuilder.buildExpectedStructure(), loader.load(accessToken));
        }
        finally {
            stopSimpleServer();
        }
    }

    private void startSimpleServer() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
            httpServer.createContext("/structures/VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw", httpExchange -> {
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