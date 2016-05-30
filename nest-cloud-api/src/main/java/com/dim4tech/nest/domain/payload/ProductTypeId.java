package com.dim4tech.nest.domain.payload;

import java.util.Objects;

public class ProductTypeId {
    private final String id;

    public ProductTypeId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTypeId productTypeId = (ProductTypeId) o;
        return Objects.equals(id, productTypeId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
