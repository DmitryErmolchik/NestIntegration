package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StructureDevices {
    private final Map<CompanyId, CompanyDevices> devices;

    public StructureDevices() {
        this(new HashMap<>());
    }

    public StructureDevices(Map<CompanyId, CompanyDevices> devices) {
        this.devices = devices;
    }

    @JsonCreator
    private static StructureDevices createFromJson(Map<String, Object> devices) {
        StructureDevices structureDevices = new StructureDevices();
        for (Map.Entry<String, Object> entry : devices.entrySet()) {
                structureDevices.devices.put(new CompanyId((String) entry.getKey()), new CompanyDevices((Map<String, Object>) entry.getValue()));
        }
        return structureDevices;
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
