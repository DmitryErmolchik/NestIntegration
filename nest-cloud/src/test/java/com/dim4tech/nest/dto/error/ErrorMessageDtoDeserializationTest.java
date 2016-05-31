package com.dim4tech.nest.dto.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ErrorMessageDtoDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String json = "{\"error\": \"No write permission(s) for field(s): temperature_scale\"," +
            "  \"type\": \"https://developer.nest.com/documentation/cloud/error-messages#no-write-permission\"," +
            "  \"message\": \"No write permission(s) for field(s): temperature_scale\"," +
            "  \"instance\": \"ee3657bc-6df3-48ad-88ec-050f59e80b24\"," +
            "  \"details\": {" +
            "    \"fields\": \"temperature_scale\"" +
            "  }" +
            "}";


    @Test
    public void deserializationTest() throws Exception {
        Map<String, String> details = new HashMap<>();
        details.put("fields", "temperature_scale");
        ErrorMessageDto expected = new ErrorMessageDto("No write permission(s) for field(s): temperature_scale",
                "https://developer.nest.com/documentation/cloud/error-messages#no-write-permission",
                "No write permission(s) for field(s): temperature_scale",
                "ee3657bc-6df3-48ad-88ec-050f59e80b24",
                details);

        ErrorMessageDto result = objectMapper.readValue(json, ErrorMessageDto.class);
        assertEquals(expected.getError(), result.getError());
        assertEquals(expected.getType(), result.getType());
        assertEquals(expected.getMessage(), result.getMessage());
        assertEquals(expected.getInstance(), result.getInstance());
        assertEquals(expected.getDetails(), result.getDetails());
    }

}
