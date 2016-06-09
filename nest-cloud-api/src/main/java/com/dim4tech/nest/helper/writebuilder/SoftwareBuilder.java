package com.dim4tech.nest.helper.writebuilder;

import com.dim4tech.nest.domain.payload.Software;

public class SoftwareBuilder {
    private String version;

    public SoftwareBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public Software build() {
        return new Software(version);
    }
}
