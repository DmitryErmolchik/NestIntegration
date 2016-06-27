package com.dim4tech.nest.service.serializer;

import com.dim4tech.nest.domain.payload.Thermostat;
import com.dim4tech.nest.domain.payload.constant.HvacMode;
import com.dim4tech.nest.helper.writebuilder.ThermostatBuilder;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SerializationServiceImplTest {
    private final SerializationService serializationService  = new SerializationServiceImpl();
    private final DeserializationService deserializationService = new DeserializationServiceImpl();

    @Test
    public void thermostatSerialize() throws Exception {
        Thermostat thermostat = new ThermostatBuilder().setLabel("Test").setHvacMode(HvacMode.HEAT).build();
        String serializedThermostat = serializationService.serialize(thermostat);
        assertTrue(serializedThermostat.contains("\"hvac_mode\":\"heat\""));
        assertTrue(serializedThermostat.contains("\"label\":\"Test\""));
        assertEquals(thermostat, deserializationService.deserialize(serializedThermostat, Thermostat.class));
    }

}