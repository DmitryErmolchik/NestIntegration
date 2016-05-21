package com.dim4tech.nest.dto.payload;

import java.util.Objects;

public class ProductId {
    private final DeviceId id;

    public ProductId(DeviceId id) {
        this.id = id;
    }

    public DeviceId getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
