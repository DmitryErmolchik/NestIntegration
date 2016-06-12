package com.dim4tech.nest.dto.error;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.domain.error.ErrorMessage;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorMessageDeserializationTest {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
    private String json = "{\"error\": \"No write permission(s) for field(s): temperature_scale\"," +
            "  \"type\": \"https://developer.nest.com/documentation/cloud/error-messages#no-write-permission\"," +
            "  \"message\": \"No write permission(s) for field(s): temperature_scale\"," +
            "  \"instance\": \"ee3657bc-6df3-48ad-88ec-050f59e80b24\"," +
            "  \"details\": {" +
            "    \"fields\": \"temperature_scale\"" +
            "  },\n" +
            "  \"error_description\": \"authorization code not found\",\n" +
            "  \"instance_id\": \"01dad188-3334-420f-b730-7a33f60a8c5e\"" +
            "}";


    @Test
    public void deserializationTest() throws Exception {
        ErrorMessage expected = ExpectedObjectsBuilder.buildExpectedErrorMessage();
        ErrorMessage result = deserializationService.deserialize(json, ErrorMessage.class);
        assertEquals(expected.getError(), result.getError());
        assertEquals(expected.getType(), result.getType());
        assertEquals(expected.getMessage(), result.getMessage());
        assertEquals(expected.getInstance(), result.getInstance());
        assertEquals(expected.getDetails(), result.getDetails());
        assertEquals(expected.getErrorDescription(), result.getErrorDescription());
        assertEquals(expected.getInstanceId(), result.getInstanceId());
    }

}
