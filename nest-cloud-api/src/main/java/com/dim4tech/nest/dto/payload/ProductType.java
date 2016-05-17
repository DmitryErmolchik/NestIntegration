package com.dim4tech.nest.dto.payload;

import java.util.Map;

public class ProductType {
    private final Map<String, Product> productType;

    public ProductType(Map<String, Product> productType) {
        this.productType = productType;
    }

    public Map<String, Product> getProductType() {
        return productType;
    }
}
