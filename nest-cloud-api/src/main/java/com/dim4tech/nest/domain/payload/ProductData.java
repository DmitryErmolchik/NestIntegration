package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductData {
    private final static String IDENTIFICATION = "identification";
    /* Contains product identifiers. */
    private final Identification identification;

    private final static String LOCATION = "location";
    /* Contains the structure identifier for your product. */
    private final ProductLocation location;

    private final static String SOFTWARE = "software";
    /* Contains the software version identifier for your product. */
    private final Software software;

    private final static String RESOURCE_USE = "resource_use";
    /* Contains the resource use data values and measurement timestamps. */
    private final Map<String, ProductResource> resourceUse;

    @JsonCreator
    public ProductData(@JsonProperty(IDENTIFICATION) Identification identification,
                       @JsonProperty(LOCATION) ProductLocation location,
                       @JsonProperty(SOFTWARE) Software software,
                       @JsonProperty(RESOURCE_USE) Map<String, ProductResource> resourceUse) {
        this.identification = identification;
        this.location = location;
        this.software = software;
        this.resourceUse = resourceUse;
    }

    public static ProductData createFromJson(Map<String, Object> productData) {
        Identification identification = null;
        ProductLocation location = null;
        Software software = null;
        Map<String, ProductResource> resopurceUse = new HashMap<>();

        for (Map.Entry<String, Object> entry : productData.entrySet()) {
            switch (entry.getKey()) {
                case IDENTIFICATION :
                    identification = Identification.createFromJson((Map<String, String>) entry.getValue());
                    break;
                case LOCATION :
                    location = ProductLocation.createFromJson((Map<String, String>) entry.getValue());
                    break;
                case SOFTWARE :
                    software = Software.createFromJson((Map<String, String>) entry.getValue());
                    break;
                case RESOURCE_USE:
                    resopurceUse = buildResourceUse((Map<String, Object>) entry.getValue());
                    break;
            }
        }
        return new ProductData(identification,
                location,
                software,
                resopurceUse.size() > 0 ? resopurceUse : null);
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

    public Map<String, ProductResource> getResourceUse() {
        return resourceUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return Objects.equals(identification, that.identification) &&
                Objects.equals(location, that.location) &&
                Objects.equals(software, that.software) &&
                Objects.equals(resourceUse, that.resourceUse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification, location, software, resourceUse);
    }
}
