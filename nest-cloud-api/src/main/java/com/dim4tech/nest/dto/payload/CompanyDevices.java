package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDevices {
    private final Map<String, ProductTypeIds> productTypes = new HashMap<>();

    @JsonCreator
    public CompanyDevices(Map<String, Object> productTypes) {
        for (Map.Entry<String, Object> entry : productTypes.entrySet()) {
            if (entry.getValue() instanceof ProductTypeIds) {
                this.productTypes.put(entry.getKey(), (ProductTypeIds) entry.getValue());
            }
            else {
                this.productTypes.put(entry.getKey(), new ProductTypeIds((List<String>) entry.getValue()));
            }
        }
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