package com.dim4tech.nest.service.serializer;

import com.dim4tech.nest.domain.payload.ProductData;
import com.dim4tech.nest.domain.payload.Software;
import com.dim4tech.nest.domain.payload.Thermostat;
import com.dim4tech.nest.domain.payload.constant.HvacMode;
import com.dim4tech.nest.helper.writebuilder.ProductDataBuilder;
import com.dim4tech.nest.helper.writebuilder.ProductResourceBuilder;
import com.dim4tech.nest.helper.writebuilder.ThermostatBuilder;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import org.joda.time.DateTime;
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

    @Test
    public void productDataSerialize() throws Exception {
        ProductData productData = new ProductDataBuilder().setSoftware(new Software("1.0"))
                .addResourceUse("electricity", new ProductResourceBuilder().setValue(42.789).setMeasurementResetTime(DateTime.parse("2016-01-01T01:01:01.000Z")).setMeasurementTime(DateTime.parse("2016-01-01T01:02:35.000Z")).build())
                .addResourceUse("gas", new ProductResourceBuilder().setValue(0.345234545).setMeasurementResetTime(DateTime.parse("2016-01-01T01:01:01.000Z")).setMeasurementTime(DateTime.parse("2016-01-01T01:02:35.000Z")).build())
                .addResourceUse("water", new ProductResourceBuilder().setValue(10000.3).setMeasurementResetTime(DateTime.parse("2016-01-01T01:01:01.000Z")).setMeasurementTime(DateTime.parse("2016-01-01T01:02:35.000Z")).build())
                .build();
        String serializedProductData = serializationService.serialize(productData);
        assertEquals(productData, deserializationService.deserialize(serializedProductData, ProductData.class));
    }
}