package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.junit.Test;

public class StructureDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json = "{  \n" +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
            " \"thermostats\": [ \"peyiJNo0IldT2YlIVtYaGQ\", \"qeyiJNo0IldT2YlIVtYaGQ\" ],\n" +
            " \"smoke_co_alarms\": [ \"RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs\", \"STMTKxsQTCxzVcsySOHPxKoF4OyCifrs\" ],\n" +
            " \"cameras\": [ \"awJo6rH…\", \"bwJo6rH…\" ],\n" +
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

    @Test
    public void deserializationTest() throws Exception {
        objectMapper.registerModule(new JodaModule());
        //Structure expected = new Structure();
        Structure result = objectMapper.readValue(json, Structure.class);
        //assertEquals(expected, result);
    }

}
