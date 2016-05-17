package com.dim4tech.nest.dto.payload;

import java.util.Map;

public class Product {
    private final Map<DeviceId, ProductData> products;

    public Product(Map<DeviceId, ProductData> products) {
        this.products = products;
    }

    public Map<DeviceId, ProductData> getProducts() {
        return products;
    }
}
