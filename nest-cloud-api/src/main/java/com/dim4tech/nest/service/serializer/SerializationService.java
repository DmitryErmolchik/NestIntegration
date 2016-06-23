package com.dim4tech.nest.service.serializer;

public interface SerializationService {
    <T> String serialize(T object);
}
