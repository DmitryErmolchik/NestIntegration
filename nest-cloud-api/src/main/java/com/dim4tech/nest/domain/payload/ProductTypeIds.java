package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTypeIds {
    private final List<DeviceId> ids;

    public ProductTypeIds(List<DeviceId> ids) {
        this.ids = ids;
    }

    @JsonCreator
    static ProductTypeIds createFromJson(List<String> ids) {
        ProductTypeIds productTypeIds = new ProductTypeIds(new ArrayList<>());
        for (String id : ids) {
            productTypeIds.ids.add(new DeviceId(id));
        }
        return productTypeIds;
    }

    public List<DeviceId> getIds() {
        return new ArrayList(ids);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTypeIds that = (ProductTypeIds) o;
        return Objects.equals(ids, that.ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids);
    }
}