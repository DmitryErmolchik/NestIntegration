package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.domain.payload.Where;
import com.dim4tech.nest.domain.payload.WhereId;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhereDeserializationTest {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
    private final String json = "{  \n" +
                                " \"where_id\": \"Fqp6wJI...\",\n" +
                                " \"name\": \"Bedroom\"\n" +
                                "}";
    @Test
    public void deserializationTest() throws Exception {
        Where result = deserializationService.deserialize(json, Where.class);
        assertEquals(buildExpectedWhere(), result);
    }

    private Where buildExpectedWhere() {
        return new Where(new WhereId("Fqp6wJI..."), "Bedroom");
    }
}
