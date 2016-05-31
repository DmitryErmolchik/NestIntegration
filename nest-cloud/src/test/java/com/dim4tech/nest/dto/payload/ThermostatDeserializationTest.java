package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.domain.payload.DeviceId;
import com.dim4tech.nest.domain.payload.StructureId;
import com.dim4tech.nest.domain.payload.Thermostat;
import com.dim4tech.nest.domain.payload.WhereId;
import com.dim4tech.nest.domain.payload.constant.HvacMode;
import com.dim4tech.nest.domain.payload.constant.HvacState;
import com.dim4tech.nest.domain.payload.constant.TemperatureScale;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ThermostatDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json = "{  " +
            " \"device_id\": \"peyiJNo0IldT2YlIVtYaGQ\"," +
            " \"locale\": \"en-US\"," +
            " \"software_version\": \"4.0\"," +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\"," +
            " \"name\": \"Hallway (upstairs)\"," +
            " \"name_long\": \"Hallway Thermostat (upstairs)\"," +
            " \"last_connection\": \"2016-10-31T23:59:59.000Z\"," +
            " \"is_online\": true," +
            " \"can_cool\": true," +
            " \"can_heat\": true," +
            " \"is_using_emergency_heat\": true," +
            " \"has_fan\": true," +
            " \"fan_timer_active\": true," +
            " \"fan_timer_timeout\": \"2016-10-31T23:59:59.000Z\"," +
            " \"has_leaf\": true," +
            " \"temperature_scale\": \"C\"," +
            " \"target_temperature_f\": 72," +
            " \"target_temperature_c\": 21.5," +
            " \"target_temperature_high_f\": 72," +
            " \"target_temperature_high_c\": 21.5," +
            " \"target_temperature_low_f\": 64," +
            " \"target_temperature_low_c\": 17.5," +
            " \"away_temperature_high_f\": 72," +
            " \"away_temperature_high_c\": 21.5," +
            " \"away_temperature_low_f\": 64," +
            " \"away_temperature_low_c\": 17.5," +
            " \"hvac_mode\": \"heat\"," +
            " \"ambient_temperature_f\": 72," +
            " \"ambient_temperature_c\": 21.5," +
            " \"humidity\": 40," +
            " \"hvac_state\": \"heating\"," +
            " \"where_id\": \"UNCBGUnN24...\"," +
            " \"is_locked\": true," +
            " \"locked_temp_min_f\": \"65\"," +
            " \"locked_temp_max_f\": \"80\"," +
            " \"locked_temp_min_c\": \"19.5\"," +
            " \"locked_temp_max_c\": \"24.5\"," +
            " \"label\": \"upstairs\"" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        objectMapper.registerModule(new JodaModule());
        Thermostat result = objectMapper.readValue(json, Thermostat.class);
        assertEquals(buildExpectedThermostat(), result);
    }

    private Thermostat buildExpectedThermostat() {
        return new Thermostat(
                new DeviceId("peyiJNo0IldT2YlIVtYaGQ"),
                new Locale("en", "us"),
                "4.0",
                new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                "Hallway (upstairs)",
                "Hallway Thermostat (upstairs)",
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                true,
                true,
                true,
                true,
                true,
                true,
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                true,
                TemperatureScale.C,
                72,
                21.5,
                72,
                21.5,
                64,
                17.5,
                72,
                21.5,
                64,
                17.5,
                HvacMode.HEAT,
                72,
                21.5,
                40,
                HvacState.HEATING,
                new WhereId("UNCBGUnN24..."),
                true,
                "65",
                "80",
                "19.5",
                "24.5",
                "upstairs");
    }
}
