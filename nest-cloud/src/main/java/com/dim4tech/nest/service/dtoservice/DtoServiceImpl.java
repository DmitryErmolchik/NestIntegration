package com.dim4tech.nest.service.dtoservice;

import com.dim4tech.nest.exception.NestIntegrationException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DtoServiceImpl<T> implements DtoService<T> {
    private final Logger LOG = LoggerFactory.getLogger(DtoServiceImpl.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final SimpleModule module = new SimpleModule();
    private final Class<T> clazz;

    public DtoServiceImpl(Class<T> clazz, JsonDeserializer<T> deserializer) {
        this.clazz = clazz;
        module.addDeserializer(this.clazz, deserializer);
        objectMapper.registerModule(module);
    }

    @Override
    public T encode(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    @Override
    public String decode(T object) {
        return null;
    }
}
