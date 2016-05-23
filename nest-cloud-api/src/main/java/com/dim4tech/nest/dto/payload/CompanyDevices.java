package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDevices {
    private final Map<String, ProductTypeIds> productTypes;

    public CompanyDevices(Map<String, ProductTypeIds> productTypes) {
        this.productTypes = productTypes;
    }

    public Map<String, ProductTypeIds> getProductTypes() {
        return productTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDevices that = (CompanyDevices) o;
        return Objects.equals(productTypes, that.productTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypes);
    }
}
