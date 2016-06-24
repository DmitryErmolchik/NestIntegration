package com.dim4tech.nest.service.publisher;

public interface Publisher<T> {
    T publish(String accessToken, T object);
}
