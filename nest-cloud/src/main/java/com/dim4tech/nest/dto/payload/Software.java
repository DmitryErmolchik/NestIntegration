package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Software {
    private final static String VERSION = "version";
    /* Software version number of your product or device. */
    private final String version;

    @JsonCreator
    public Software(@JsonProperty(VERSION) String version) {
        this.version = version;
    }

    public static Software createFromJson(Map<String, String> identificationData) {
        String version = null;
        for (Map.Entry<String, String> entry : identificationData.entrySet()) {
            switch (entry.getKey()) {
                case VERSION:
                    version = entry.getValue();
                    break;
            }
        }
        return new Software(version);
    }

    public String getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Software software = (Software) o;
        return Objects.equals(version, software.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }
}
