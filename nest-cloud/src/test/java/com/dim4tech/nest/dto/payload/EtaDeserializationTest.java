package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.domain.payload.Eta;
import com.dim4tech.nest.domain.payload.TripId;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EtaDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json = "{  \n" +
            " \"trip_id\": \"myTripHome1024\",\n" +
            " \"estimated_arrival_window_begin\": \"2016-10-31T22:42:59.000Z\",\n" +
            " \"estimated_arrival_window_end\": \"2016-10-31T23:59:59.000Z\"\n" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        objectMapper.registerModule(new JodaModule());
        Eta expected = buildExpectedEta();
        Eta result = objectMapper.readValue(json, Eta.class);
        assertEquals(expected, result);
    }

    private Eta buildExpectedEta() {
        return new Eta(
                new TripId("myTripHome1024"),
                DateTime.parse("2016-10-31T22:42:59.000Z"),
                DateTime.parse("2016-10-31T23:59:59.000Z")
        );
    }
}
