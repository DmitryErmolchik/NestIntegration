package com.dim4tech.nest.service.dtoservice;

public interface DtoService<T> {
    T encode(String jsonString, Class<T> clazz);
    String decode(T object);
}
