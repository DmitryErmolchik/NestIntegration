package com.dim4tech.nest.domain.payload;

import java.util.Map;
import java.util.Objects;

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
