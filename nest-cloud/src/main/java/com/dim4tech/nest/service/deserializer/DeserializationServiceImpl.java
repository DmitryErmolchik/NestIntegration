package com.dim4tech.nest.service.deserializer;

import com.dim4tech.nest.exception.NestIntegrationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DeserializationServiceImpl implements DeserializationService {
    private final Logger LOG = LoggerFactory.getLogger(DeserializationServiceImpl.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DeserializationServiceImpl() {
        objectMapper.registerModule(new JodaModule());
    }

    @Override
    public <T> T deserialize(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
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
