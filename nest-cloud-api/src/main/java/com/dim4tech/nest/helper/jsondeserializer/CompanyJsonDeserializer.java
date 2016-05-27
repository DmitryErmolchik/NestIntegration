package com.dim4tech.nest.helper.jsondeserializer;

import com.dim4tech.nest.dto.payload.ProductType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Map;

public class CompanyJsonDeserializer extends JsonDeserializer<Map<String, ProductType>> {
    @Override
    public Map<String, ProductType> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return null;
    }
}
