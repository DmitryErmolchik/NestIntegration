package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductType {
    private final Map<ProductTypeId, Product> productType;

    public ProductType(Map<ProductTypeId, Product> productType) {
        this.productType = productType;
    }

    @JsonCreator
    public static ProductType createFromJson(Map<String, Object> props) {
        ProductType productTypeIntance = new ProductType(new HashMap<>());
        for (Map.Entry<String, Object> entry : props.entrySet()) {
            productTypeIntance.productType.put(new ProductTypeId(entry.getKey()), Product.createFromJson((Map<String, Object>) entry.getValue()));
        }
        return productTypeIntance;
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
