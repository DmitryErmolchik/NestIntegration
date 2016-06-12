package com.dim4tech.nest.service.loader;

public interface Loader<T> {
    T load(String accessToken);
}
