package com.dim4tech.nest.helper.writebuilder;

import com.dim4tech.nest.domain.payload.Camera;

public class CameraBuilder {

    private Boolean isStreaming;

    public CameraBuilder setIsStreaming(Boolean isStreaming) {
        this.isStreaming = isStreaming;
        return this;
    }

    public Camera build() {
        return new Camera(null, null, null, null, null, null, null, isStreaming,
                null, null, null, null, null, null, null, null, null, null);
    }
}
