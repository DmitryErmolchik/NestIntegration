package com.dim4tech.nest.dto.payload;

public class ProductId {
    private final DeviceId id;

    public ProductId(DeviceId id) {
        this.id = id;
    }

    public DeviceId getId() {
        return id;
    }
}
