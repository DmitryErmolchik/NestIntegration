package com.dim4tech.nest.service.deserializer;

import com.dim4tech.nest.domain.payload.Devices;
import com.dim4tech.nest.domain.payload.NestData;
import com.dim4tech.nest.domain.payload.ProductType;
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
            if (clazz.equals(Devices.class)) {
                return (T) readDevices(jsonString);
            } else if (clazz.equals(NestData.class)) {
                NestData nestData = objectMapper.readValue(jsonString, NestData.class);
                return (T) new NestData(nestData.getMetadata(),
                                        readDevices(jsonString),
                                        nestData.getStructure());
            }
            else {
                return objectMapper.readValue(jsonString, clazz);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    private Devices readDevices(String jsonString) {
        final Map<String, ProductType> companies = new HashMap<>();
        try {
            JsonNode node = objectMapper.readTree(jsonString).get("devices");
            if (node == null) {
                node = objectMapper.readTree(jsonString);
            }
            Iterator<Map.Entry<String, JsonNode>> iteratorDevices = node.fields();
            while (iteratorDevices.hasNext()) {
                Map.Entry<String, JsonNode> devices = iteratorDevices.next();
                switch (devices.getKey()) {
                    case Devices.THERMOSTATS:
                    case Devices.CAMERAS:
                    case Devices.SMOKE_CO_ALARMS:
                        break;
                    default:
                        try {
                            ProductType productType = objectMapper.readValue(devices.getValue().toString(), ProductType.class);
                            companies.put(devices.getKey(), productType);
                        } catch (IOException e) {
                            throw new NestIntegrationException();
                        }
                        break;
                }
            }
            Devices tempDevices = objectMapper.readValue(node.toString(), Devices.class);
            return new Devices(tempDevices.getThermostats(), tempDevices.getSmokeCoAlarms(), tempDevices.getCameras(), companies);
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
