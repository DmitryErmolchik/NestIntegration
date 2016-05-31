package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.domain.payload.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetadataDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json = "{  \n" +
            " \"access_token\": \"c.FmDPkzyzaQe...\",\n" +
            " \"client_version\": 1\n" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        Metadata result = objectMapper.readValue(json, Metadata.class);
        assertEquals(buildExpectedMetadate(), result);
    }

    private Metadata buildExpectedMetadate() {
        return new Metadata(
                "c.FmDPkzyzaQe...",
                1
        );
    }
}
