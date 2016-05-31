package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LastEventDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
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
        objectMapper.registerModule(new JodaModule());
        LastEvent result = objectMapper.readValue(json, LastEvent.class);
        assertEquals(buildExpectedLastEvent(), result);
    }

    private LastEvent buildExpectedLastEvent() {
        List<ActivityZoneId> activityZoneIds = new ArrayList<>();
        activityZoneIds.add(new ActivityZoneId("244083"));
        activityZoneIds.add(new ActivityZoneId("244084"));
        activityZoneIds.add(new ActivityZoneId("244085"));
        return new LastEvent(
                true,
                true,
                DateTime.parse("2016-12-29T00:00:00.000Z"),
                DateTime.parse("2016-12-29T18:42:00.000Z"),
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                "https://home.nest.com/cameras/device_id/cuepoints/STRING?auth=access_token",
                "nestmobile://cameras/device_id/cuepoints/STRING?auth=access_token",
                "STRING1/device_id/STRING2?auth=access_token",
                "STRING1/device_id/STRING2?auth=access_token",
                activityZoneIds
        );
    }
}
