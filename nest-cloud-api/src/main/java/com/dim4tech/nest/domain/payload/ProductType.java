package com.dim4tech.nest.domain.payload;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductType {
    private final Map<ProductTypeId, Product> productType;

    public ProductType(Map<ProductTypeId, Product> productType) {
        this.productType = productType;
    }

    public Map<ProductTypeId, Product> getProductType() {
        return new HashMap<>(productType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return Objects.equals(productType, that.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType);
    }
}
