package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class DeviceId {
    /* Device unique identifier */
    private final String id;

    @JsonCreator
    public DeviceId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceId deviceId = (DeviceId) o;
        return Objects.equals(id, deviceId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
