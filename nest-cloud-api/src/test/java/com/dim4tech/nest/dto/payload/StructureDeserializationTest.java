package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.dto.payload.constants.AwayState;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

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
        Structure result = objectMapper.readValue(json, Structure.class);
        assertEquals(buildExpectedStructure(), result);
    }

    private Structure buildExpectedStructure() {
        Map<String, Object>  productTypes = new HashMap<>();
        productTypes.put("$product_type", new ProductTypeIds(
                Arrays.asList("CPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg",
                "DPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg")));
        CompanyDevices companyDevices = new CompanyDevices(productTypes);

        Map<CompanyId, CompanyDevices> company = new HashMap<>();
        company.put(new CompanyId("$company"), companyDevices);

        StructureDevices devices = new StructureDevices(company);

        Map<WhereId, Where> wheres = new HashMap<>();
        wheres.put(new WhereId("Fqp6wJI..."), new Where(new WhereId("Fqp6wJI..."), "Bedroom"));

        Structure expected = new Structure(
                new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                Arrays.asList(new DeviceId("peyiJNo0IldT2YlIVtYaGQ"), new DeviceId("qeyiJNo0IldT2YlIVtYaGQ")),
                Arrays.asList(new DeviceId("RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs"), new DeviceId("STMTKxsQTCxzVcsySOHPxKoF4OyCifrs")),
                Arrays.asList(new DeviceId("awJo6rH…"), new DeviceId("bwJo6rH…")),
                devices,
                AwayState.HOME,
                "Home",
                "US",
                "94304",
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                TimeZone.getTimeZone("America/Los_Angeles"),
                new Eta(new TripId("myTripHome1024"),
                        DateTime.parse("2016-10-31T22:42:59.000Z"),
                        DateTime.parse("2016-10-31T23:59:59.000Z")),
                true,
                wheres);
        return expected;
    }
}
