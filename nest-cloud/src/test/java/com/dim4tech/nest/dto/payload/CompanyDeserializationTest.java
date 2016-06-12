package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.domain.payload.ProductType;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CompanyDeserializationTest {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
    private final String json = "{  \n" +
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

    @Test
    public void deserializationTest() throws Exception {
        Map<String, ProductType> result = deserializationService.deserialize(json, new TypeReference<Map<String, ProductType>>() {});
        assertEquals(ExpectedObjectsBuilder.buildExpectedCompany(), result);
    }
}
