package com.dim4tech.nest.domain.payload;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductTypeIds {
    private final List<DeviceId> ids;

    public ProductTypeIds(List<DeviceId> ids) {
        this.ids = ids;
    }

    public List<DeviceId> getIds() {
        return new ArrayList(ids);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTypeIds that = (ProductTypeIds) o;
        return Objects.equals(ids, that.ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids);
    }
}