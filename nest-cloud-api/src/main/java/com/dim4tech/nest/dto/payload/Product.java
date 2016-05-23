package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private final Map<DeviceId, ProductData> products;

    public Product(Map<DeviceId, ProductData> products) {
        this.products = products;
    }

    public Map<DeviceId, ProductData> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(products, product.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
