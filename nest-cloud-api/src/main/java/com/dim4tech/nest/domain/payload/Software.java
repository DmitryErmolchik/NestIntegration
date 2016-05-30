package com.dim4tech.nest.domain.payload;

import java.util.Objects;

public class Software {
    /* Software version number of your product or device. */
    private final String version;

    public Software(String version) {
        this.version = version;
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
