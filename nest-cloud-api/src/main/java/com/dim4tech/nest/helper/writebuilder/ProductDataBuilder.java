package com.dim4tech.nest.helper.writebuilder;

import com.dim4tech.nest.domain.payload.ProductData;
import com.dim4tech.nest.domain.payload.ProductResource;
import com.dim4tech.nest.domain.payload.Software;

import java.util.HashMap;
import java.util.Map;

public class ProductDataBuilder {
    private Software software;
    private Map<String, ProductResource> resourceUse;

    public ProductDataBuilder setSoftware(Software software) {
        this.software = software;
        return this;
    }

    public ProductDataBuilder addResourceUse(String resourceName, ProductResource productResource) {
        if (resourceUse == null) {
            resourceUse = new HashMap<>();
        }
        resourceUse.put(resourceName, productResource);
        return this;
    }

    public ProductDataBuilder removeResourceUse(String resourceName) {
        resourceUse.remove(resourceName);
        if (resourceUse.size() == 0) {
            resourceUse = null;
        }
        return this;
    }

    public ProductData build() {
        return new ProductData(null, null, software, resourceUse);
    }
}
