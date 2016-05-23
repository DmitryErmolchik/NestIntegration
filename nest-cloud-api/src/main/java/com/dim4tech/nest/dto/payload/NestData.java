package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NestData {
    private final static String METADATA = "metadata";
    /*
        Additional information that is provided when you make a REST Streaming call with Multiuser integration
     */
    private final Metadata metadata;

    private final static String DEVICES = "devices";
    /*
        Devices in the structure
     */
    private final Devices devices;

    private final static String STRUCTURES = "structures";
    /*
        Structure
     */
    private final Map<StructureId, Structure> structure;

    @JsonCreator
    public NestData(@JsonProperty(METADATA) Metadata metadata,
                    @JsonProperty(DEVICES) Devices devices,
                    @JsonProperty(STRUCTURES) Map<StructureId, Structure> structure) {
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
