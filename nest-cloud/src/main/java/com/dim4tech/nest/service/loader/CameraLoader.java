package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.Camera;

import java.net.URL;

public class CameraLoader extends AbstractLoader<Camera> {

    public CameraLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public CameraLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Camera load(String accessToken) {
        return loadJsonData(accessToken, Camera.class);
    }
}
