package com.dim4tech.nest.service.dtoservice;

public interface DtoService<T> {
    T encode(String jsonString);
    String decode(T object);
}
