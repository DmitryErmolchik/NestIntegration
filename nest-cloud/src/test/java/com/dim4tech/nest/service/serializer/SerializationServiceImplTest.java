package com.dim4tech.nest.service.serializer;

import com.dim4tech.nest.domain.payload.constant.HvacMode;
import com.dim4tech.nest.helper.writebuilder.ThermostatBuilder;
import org.junit.Test;

public class SerializationServiceImplTest {
    private final SerializationService serializationService  = new SerializationServiceImpl();
    @Test
    public void serialize() throws Exception {
        serializationService.serialize(new ThermostatBuilder().setLabel("Test").setHvacMode(HvacMode.HEAT).build());
    }

}