package com.dim4tech.nest.dto.error;

import com.dim4tech.nest.domain.error.ErrorMessage;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ErrorMessageDeserializationTest {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
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
        ErrorMessage expected = new ErrorMessage("No write permission(s) for field(s): temperature_scale",
                "https://developer.nest.com/documentation/cloud/error-messages#no-write-permission",
                "No write permission(s) for field(s): temperature_scale",
                "ee3657bc-6df3-48ad-88ec-050f59e80b24",
                details);

        ErrorMessage result = deserializationService.deserialize(json, ErrorMessage.class);
        assertEquals(expected.getError(), result.getError());
        assertEquals(expected.getType(), result.getType());
        assertEquals(expected.getMessage(), result.getMessage());
        assertEquals(expected.getInstance(), result.getInstance());
        assertEquals(expected.getDetails(), result.getDetails());
    }

}
