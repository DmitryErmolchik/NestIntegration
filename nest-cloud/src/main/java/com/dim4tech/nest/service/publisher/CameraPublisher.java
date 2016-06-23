package com.dim4tech.nest.service.publisher;

import com.dim4tech.nest.domain.payload.Camera;

import java.net.URL;

public class CameraPublisher extends AbstractPublisher<Camera> {
    protected CameraPublisher(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    protected CameraPublisher(URL endpoint) {
        super(endpoint);
    }

    @Override
    public void publish(String accessToken, Camera object) {
        this.publishObject(accessToken, object, Camera.class);
    }
}
