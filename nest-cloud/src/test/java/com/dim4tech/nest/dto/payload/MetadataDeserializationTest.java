package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.domain.payload.Metadata;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetadataDeserializationTest {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
    private final String json = "{  \n" +
            " \"access_token\": \"c.FmDPkzyzaQe...\",\n" +
            " \"client_version\": 1\n" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        Metadata result = deserializationService.deserialize(json, Metadata.class);
        assertEquals(ExpectedObjectsBuilder.buildExpectedMetadata(), result);
    }
}
