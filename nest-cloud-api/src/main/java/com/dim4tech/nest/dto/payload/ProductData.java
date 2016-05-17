package com.dim4tech.nest.dto.payload;

import java.util.Map;

public class ProductData {
    /* Contains product identifiers. */
    private final Identification identification;

    /* Contains the structure identifier for your product. */
    private final ProductLocation location;

    /* Contains the software version identifier for your product. */
    private final Software software;

    /* Contains the resource use data values and measurement timestamps. */
    private final Map<String, ProductResource> resopurceUse;

    public ProductData(Identification identification, ProductLocation location,
                       Software software, Map<String, ProductResource> resopurceUse) {
        this.identification = identification;
        this.location = location;
        this.software = software;
        this.resopurceUse = resopurceUse;
    }

    public Identification getIdentification() {
        return identification;
    }

    public ProductLocation getLocation() {
        return location;
    }

    public Software getSoftware() {
        return software;
    }

    public Map<String, ProductResource> getResopurceUse() {
        return resopurceUse;
    }
}
