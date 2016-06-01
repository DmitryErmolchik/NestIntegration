package com.dim4tech.nest.service.deserializer;

import com.dim4tech.nest.domain.payload.Devices;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class DevicesDeserializer extends JsonDeserializer<Devices> {
    @Override
    public Devices deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return null;
    }
}
