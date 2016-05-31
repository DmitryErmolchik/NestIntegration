package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.domain.payload.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CameraDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json = "{ \n" +
            " \"device_id\": \"awJo6rH...\",\n" +
            " \"software_version\": \"4.0\",\n" +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
            " \"where_id\": \"d6reb_OZTM...\",\n" +
            " \"name\": \"Hallway (upstairs)\",\n" +
            " \"name_long\": \"Hallway Camera (upstairs)\",\n" +
            " \"is_online\": true,\n" +
            " \"is_streaming\": true,\n" +
            " \"is_audio_input_enabled\": true,\n" +
            " \"last_is_online_change\": \"2016-12-29T18:42:00.000Z\",\n" +
            " \"is_video_history_enabled\": true,\n" +
            " \"web_url\": \"https://home.nest.com/cameras/device_id?auth=access_token\",\n" +
            " \"app_url\": \"nestmobile://cameras/device_id?auth=access_token\",\n" +
            " \"is_public_share_enabled\": true,\n" +
            " \"activity_zones\": [ { \"name\": \"Walkway 1\", \"id\": \"244083\" }, " +
                                   "{ \"name\": \"Walkway 2\", \"id\": \"244084\" }, " +
                                   "{ \"name\": \"Walkway 3\", \"id\": \"244085\" } ],\n" +
            " \"public_share_url\": \"https://video.nest.com/live/STRING1?STRING2\",\n" +
            " \"snapshot_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
            "\"last_event\": {  \n" +
            " \"has_sound\": true,\n" +
            " \"has_motion\": true,\n" +
            " \"start_time\": \"2016-12-29T00:00:00.000Z\",\n" +
            " \"end_time\": \"2016-12-29T18:42:00.000Z\",\n" +
            " \"urls_expire_time\": \"2016-10-31T23:59:59.000Z\",\n" +
            " \"web_url\": \"https://home.nest.com/cameras/device_id/cuepoints/STRING?auth=access_token\",\n" +
            " \"app_url\": \"nestmobile://cameras/device_id/cuepoints/STRING?auth=access_token\",\n" +
            " \"image_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
            " \"animated_image_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
            " \"activity_zone_ids\": [ \"244083\", \"244084\", \"244085\" ]\n" +
            "}\n" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        objectMapper.registerModule(new JodaModule());
        Camera result = objectMapper.readValue(json, Camera.class);
        assertEquals(buildExpectedCamera(), result);
    }

    private Camera buildExpectedCamera() {
        List<ActivityZoneId> activityZoneIds = new ArrayList<>();
        activityZoneIds.add(new ActivityZoneId("244083"));
        activityZoneIds.add(new ActivityZoneId("244084"));
        activityZoneIds.add(new ActivityZoneId("244085"));

        List<ActivityZone> expectedActivityZones = new ArrayList<>();
        expectedActivityZones.add(new ActivityZone(new ActivityZoneId("244083"), "Walkway 1"));
        expectedActivityZones.add(new ActivityZone(new ActivityZoneId("244084"), "Walkway 2"));
        expectedActivityZones.add(new ActivityZone(new ActivityZoneId("244085"), "Walkway 3"));

        LastEvent expectedLastEvent = new LastEvent(
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
        Camera expectedCamera = new Camera(
                new DeviceId("awJo6rH..."),
                "4.0",
                new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                new WhereId("d6reb_OZTM..."),
                "Hallway (upstairs)",
                "Hallway Camera (upstairs)",
                true,
                true,
                true,
                DateTime.parse("2016-12-29T18:42:00.000Z"),
                true,
                "https://home.nest.com/cameras/device_id?auth=access_token",
                "nestmobile://cameras/device_id?auth=access_token",
                true,
                expectedActivityZones,
                "https://video.nest.com/live/STRING1?STRING2",
                "STRING1/device_id/STRING2?auth=access_token",
                expectedLastEvent
        );
        return expectedCamera;
    }
}
