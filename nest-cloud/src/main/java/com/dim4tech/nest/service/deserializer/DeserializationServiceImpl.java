package com.dim4tech.nest.service.deserializer;

import com.dim4tech.nest.domain.payload.*;
import com.dim4tech.nest.exception.NestIntegrationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DeserializationServiceImpl implements DeserializationService {
    private final Logger LOG = LoggerFactory.getLogger(DeserializationServiceImpl.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DeserializationServiceImpl() {
        objectMapper.registerModule(new JodaModule());
    }

    @Override
    public <T> T deserialize(String jsonString, Class<T> clazz) {
        try {
            if (!clazz.equals(NestData.class)) {
                return objectMapper.readValue(jsonString, clazz);
            }
            else {
                final Map<String, ProductType> companies = new HashMap<>();
                Map<DeviceId, Thermostat> thermostats;
                T nestData = objectMapper.readValue(jsonString, clazz);
                JsonNode node = objectMapper.readTree(jsonString).at("/devices");

                Iterator<Map.Entry<String, JsonNode>> iteratorDevices = node.fields();
                while (iteratorDevices.hasNext())

                node.fields().forEachRemaining((action) -> {
                    switch (action.getKey()) {
                        case Devices.THERMOSTATS:
                            thermostats = this.deserialize(action.getValue().toString(), new TypeReference<Map<DeviceId, Thermostat>>() {});
                            break;
                        case Devices.CAMERAS:
                            Map<DeviceId, Thermostat> cameras = this.deserialize(action.getValue().toString(), new TypeReference<Map<DeviceId, Camera>>() {});
                            break;
                        case Devices.SMOKE_CO_ALARMS:
                            Map<DeviceId, Thermostat> smokeCoAlarms = this.deserialize(action.getValue().toString(), new TypeReference<Map<DeviceId, SmokeCoAlarm>>() {});
                            break;
                        default:
                            try {
                                ProductType productType = objectMapper.readValue(action.getValue().toString(), ProductType.class);
                                companies.put(action.getKey(), productType);
                            } catch (IOException e) {
                                throw new NestIntegrationException();
                            }
                            break;
                    }
                    }
                });
                Devices devices = objectMapper.readValue(node.toString(), Devices.class);
                return nestData;
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    @Override
    public <T> T deserialize(String jsonString, TypeReference valueTypeRef) {
        try {
            return objectMapper.readValue(jsonString, valueTypeRef);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }
}
