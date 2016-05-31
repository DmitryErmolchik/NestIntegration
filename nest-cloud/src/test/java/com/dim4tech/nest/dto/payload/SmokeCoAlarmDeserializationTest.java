package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.domain.payload.constants.AlarmState;
import com.dim4tech.nest.domain.payload.constants.BatteryHealth;
import com.dim4tech.nest.domain.payload.constants.UiColorState;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class SmokeCoAlarmDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
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
        objectMapper.registerModule(new JodaModule());
        SmokeCoAlarm result = objectMapper.readValue(json, SmokeCoAlarm.class);
        assertEquals(buildExpectedSmokeCoAlarm(), result);
    }

    private SmokeCoAlarm buildExpectedSmokeCoAlarm() {
        return new SmokeCoAlarm(
                new DeviceId("RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs"),
                Locale.US,
                "1.01",
                new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                "Hallway (upstairs)",
                "Hallway Protect (upstairs)",
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                true,
                BatteryHealth.OK,
                AlarmState.OK,
                AlarmState.OK,
                true,
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                UiColorState.GRAY,
                new WhereId("UNCBGUnN24...")
        );
    }
}
