package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StructureDevices {
    private final Map<CompanyId, CompanyDevices> devices;

    public StructureDevices(Map<CompanyId, CompanyDevices> devices) {
        this.devices = devices;
    }

    @JsonCreator
    static StructureDevices createFromJson(Map<String, Object> devices) {
        StructureDevices structureDevices = new StructureDevices(new HashMap<>());
        for (Map.Entry<String, Object> entry : devices.entrySet()) {
                structureDevices.devices.put(new CompanyId(entry.getKey()), CompanyDevices.createFromJson((Map<String, Object>) entry.getValue()));
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
