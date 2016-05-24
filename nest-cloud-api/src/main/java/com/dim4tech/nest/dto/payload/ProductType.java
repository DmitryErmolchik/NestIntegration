package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductType {
    private final Map<ProductTypeId, Product> productType = new HashMap<>();

    @JsonCreator
    public ProductType(Map<String, Object> props) {
        props.forEach((productId, product) -> productType.put(new ProductTypeId(productId), new Product((Map<String, Object>) product)));
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
