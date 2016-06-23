package com.dim4tech.nest.service.publisher;

public interface Publisher<T> {
    void publish(String accessToken, T object);
}
