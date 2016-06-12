package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.domain.payload.LastEvent;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastEventDeserializationTest {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
    private final String json = "{ " +
            " \"has_sound\": true," +
            " \"has_motion\": true," +
            " \"start_time\": \"2016-12-29T00:00:00.000Z\"," +
            " \"end_time\": \"2016-12-29T18:42:00.000Z\"," +
            " \"urls_expire_time\": \"2016-10-31T23:59:59.000Z\"," +
            " \"web_url\": \"https://home.nest.com/cameras/device_id/cuepoints/STRING?auth=access_token\"," +
            " \"app_url\": \"nestmobile://cameras/device_id/cuepoints/STRING?auth=access_token\"," +
            " \"image_url\": \"STRING1/device_id/STRING2?auth=access_token\"," +
            " \"animated_image_url\": \"STRING1/device_id/STRING2?auth=access_token\"," +
            " \"activity_zone_ids\": [ \"244083\", \"244084\", \"244085\" ]" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        LastEvent result = deserializationService.deserialize(json, LastEvent.class);
        assertEquals(ExpectedObjectsBuilder.buildExpectedLastEvent(), result);
    }
}
