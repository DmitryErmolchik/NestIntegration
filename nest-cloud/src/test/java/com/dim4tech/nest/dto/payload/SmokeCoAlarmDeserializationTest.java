package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.domain.payload.SmokeCoAlarm;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmokeCoAlarmDeserializationTest {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
    private final String json = "{  " +
            " \"device_id\": \"RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs\"," +
            " \"locale\": \"en-US\"," +
            " \"software_version\": \"1.01\"," +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\"," +
            " \"name\": \"Hallway (upstairs)\"," +
            " \"name_long\": \"Hallway Protect (upstairs)\"," +
            " \"last_connection\": \"2016-10-31T23:59:59.000Z\"," +
            " \"is_online\": true," +
            " \"battery_health\": \"ok\"," +
            " \"co_alarm_state\": \"ok\"," +
            " \"smoke_alarm_state\": \"ok\"," +
            " \"is_manual_test_active\": true," +
            " \"last_manual_test_time\": \"2016-10-31T23:59:59.000Z\"," +
            " \"ui_color_state\": \"gray\"," +
            " \"where_id\": \"UNCBGUnN24...\"" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        SmokeCoAlarm result = deserializationService.deserialize(json, SmokeCoAlarm.class);
        assertEquals(ExpectedObjectsBuilder.buildExpectedSmokeCoAlarm(), result);
    }
}
