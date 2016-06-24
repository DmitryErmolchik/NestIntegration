package com.dim4tech.nest.service.publisher;

import com.dim4tech.nest.domain.payload.Eta;

import java.net.URL;

public class EtaPublisher extends AbstractPublisher<Eta> {
    protected EtaPublisher(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    protected EtaPublisher(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Eta publish(String accessToken, Eta object) {
        return this.publishObject(accessToken, object, Eta.class);
    }
}
