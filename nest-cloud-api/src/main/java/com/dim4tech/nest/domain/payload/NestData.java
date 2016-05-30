package com.dim4tech.nest.domain.payload;

import java.util.Map;
import java.util.Objects;

public class NestData {
    /*
        Additional information that is provided when you make a REST Streaming call with Multiuser integration
     */
    private final Metadata metadata;

    /*
        Devices in the structure
     */
    private final Devices devices;

    /*
        Structure
     */
    private final Map<StructureId, Structure> structure;

    public NestData(Metadata metadata,
                    Devices devices,
                    Map<StructureId, Structure> structure) {
        this.metadata = metadata;
        this.devices = devices;
        this.structure = structure;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public Devices getDevices() {
        return devices;
    }

    public Map<StructureId, Structure> getStructure() {
        return structure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NestData nestData = (NestData) o;
        return Objects.equals(metadata, nestData.metadata) &&
                Objects.equals(devices, nestData.devices) &&
                Objects.equals(structure, nestData.structure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, devices, structure);
    }
}
