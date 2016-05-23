package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductType {
    private final Map<ProductId, Product> productType;

    public ProductType(Map<ProductId, Product> productType) {
        this.productType = productType;
    }

    public Map<ProductId, Product> getProductType() {
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
