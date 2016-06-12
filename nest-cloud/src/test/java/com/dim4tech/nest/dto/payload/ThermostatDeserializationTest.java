package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.common.ExpectedObjectsBuilder;
import com.dim4tech.nest.domain.payload.Thermostat;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThermostatDeserializationTest {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
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
        Thermostat result = deserializationService.deserialize(json, Thermostat.class);
        assertEquals(ExpectedObjectsBuilder.buildExpectedThermostat(), result);
    }
}
