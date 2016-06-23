package com.dim4tech.nest.service.serializer;

import com.dim4tech.nest.exception.NestIntegrationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerializationServiceImpl implements SerializationService {
    private final Logger LOG = LoggerFactory.getLogger(SerializationServiceImpl.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public SerializationServiceImpl() {
        objectMapper.registerModule(new JodaModule());
    }

    @Override
    public <T> String serialize(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }
}
