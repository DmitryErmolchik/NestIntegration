package com.dim4tech.nest.dto.payload;

import java.util.Map;

public class CompanyDevices {
    private final Map<String, ProductTypeIds> productTypes;

    public CompanyDevices(Map<String, ProductTypeIds> productTypes) {
        this.productTypes = productTypes;
    }

    public Map<String, ProductTypeIds> getProductTypes() {
        return productTypes;
    }
}
