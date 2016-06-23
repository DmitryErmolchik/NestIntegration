package com.dim4tech.nest.service.publisher;

import com.dim4tech.nest.domain.payload.Software;

import java.net.URL;

public class SoftwarePublisher extends AbstractPublisher<Software> {
    protected SoftwarePublisher(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    protected SoftwarePublisher(URL endpoint) {
        super(endpoint);
    }

    @Override
    public void publish(String accessToken, Software object) {
        this.publishObject(accessToken, object, Software.class);
    }
}
