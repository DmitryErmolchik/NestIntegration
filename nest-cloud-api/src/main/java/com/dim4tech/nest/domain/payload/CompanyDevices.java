package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDevices {
    private final Map<String, ProductTypeIds> productTypes;

    public CompanyDevices(Map<String, ProductTypeIds> productTypes) {
        this.productTypes = productTypes;
    }

    @JsonCreator
    static CompanyDevices createFromJson(Map<String, Object> productTypes) {
        CompanyDevices companyDevices = new CompanyDevices(new HashMap<>());
        for (Map.Entry<String, Object> entry : productTypes.entrySet()) {
            companyDevices.productTypes.put(entry.getKey(), ProductTypeIds.createFromJson((List<String>) entry.getValue()));
        }
        return companyDevices;
    }

    public Map<String, ProductTypeIds> getProductTypes() {
        return new HashMap<>(productTypes);
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