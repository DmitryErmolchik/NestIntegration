package com.dim4tech.nest.domain.payload;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StructureDevices {
    private final Map<CompanyId, CompanyDevices> devices;

    public StructureDevices(Map<CompanyId, CompanyDevices> devices) {
        this.devices = devices;
    }

    public Map<CompanyId, CompanyDevices> getDevices() {
        return new HashMap<>(devices);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructureDevices that = (StructureDevices) o;
        return Objects.equals(devices, that.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(devices);
    }
}
