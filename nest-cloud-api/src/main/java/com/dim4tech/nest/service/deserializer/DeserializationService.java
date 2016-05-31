package com.dim4tech.nest.service.deserializer;

import com.fasterxml.jackson.core.type.TypeReference;

public interface DeserializationService {
    <T> T deserialize(String jsonString, Class<T> clazz);
    <T> T deserialize(String jsonString, TypeReference valueTypeRef);
}
