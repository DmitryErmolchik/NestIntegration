package com.dim4tech.nest.dto.payload;

public class Software {
    private String version;

    public Software(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Software software = (Software) o;

        return version.equals(software.version);

    }

    @Override
    public int hashCode() {
        return version.hashCode();
    }
}
