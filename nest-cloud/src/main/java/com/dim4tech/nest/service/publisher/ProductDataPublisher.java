package com.dim4tech.nest.service.publisher;

import com.dim4tech.nest.domain.payload.ProductData;

import java.net.URL;

public class ProductDataPublisher extends AbstractPublisher<ProductData> {
    protected ProductDataPublisher(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    protected ProductDataPublisher(URL endpoint) {
        super(endpoint);
    }

    @Override
    public void publish(String accessToken, ProductData object) {
        this.publishObject(accessToken, object, ProductData.class);
    }
}
