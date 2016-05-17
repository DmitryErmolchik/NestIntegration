package com.dim4tech.nest.dto.payload;

public class DeviceId {
    /* Device unique identifier */
    private final String id;

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

        return id.equals(deviceId.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
