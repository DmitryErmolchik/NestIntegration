package com.dim4tech.nest.domain.payload;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductData {
    /* Contains product identifiers. */
    private final Identification identification;

    /* Contains the structure identifier for your product. */
    private final ProductLocation location;

    /* Contains the software version identifier for your product. */
    private final Software software;

    /* Contains the resource use data values and measurement timestamps. */
    private final Map<String, ProductResource> resopurceUse;

    public ProductData(Identification identification,
                       ProductLocation location,
                       Software software,
                       Map<String, ProductResource> resopurceUse) {
        this.identification = identification;
        this.location = location;
        this.software = software;
        this.resopurceUse = resopurceUse;
    }

    private static Map<String, ProductResource> buildResourceUse(Map<String, Object> data) {
        Map<String, ProductResource> resources = new HashMap<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            resources.put(entry.getKey(), ProductResource.createFromJson((Map<String, Object>) entry.getValue()));
        }
        return resources;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return Objects.equals(identification, that.identification) &&
                Objects.equals(location, that.location) &&
                Objects.equals(software, that.software) &&
                Objects.equals(resopurceUse, that.resopurceUse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification, location, software, resopurceUse);
    }
}
