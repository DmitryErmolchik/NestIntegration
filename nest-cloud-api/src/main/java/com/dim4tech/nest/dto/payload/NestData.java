package com.dim4tech.nest.dto.payload;

import java.util.Map;

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

    public NestData(Metadata metadata, Devices devices, Map<StructureId, Structure> structure) {
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
}
