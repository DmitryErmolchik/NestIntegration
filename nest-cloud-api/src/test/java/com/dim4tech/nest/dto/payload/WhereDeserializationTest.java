package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhereDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json = "{  \n" +
                                " \"where_id\": \"Fqp6wJI...\",\n" +
                                " \"name\": \"Bedroom\"\n" +
                                "}";
    @Test
    public void deserializationTest() throws Exception {
        Where result = objectMapper.readValue(json, Where.class);
        assertEquals(buildExpectedWhere(), result);
    }

    private Where buildExpectedWhere() {
        return new Where(new WhereId("Fqp6wJI..."), "Bedroom");
    }
}
