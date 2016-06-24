package com.dim4tech.nest.service.publisher;

import com.dim4tech.nest.domain.payload.ProductResource;

import java.net.URL;

public class ProductResourcePublisher extends AbstractPublisher<ProductResource> {
    protected ProductResourcePublisher(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    protected ProductResourcePublisher(URL endpoint) {
        super(endpoint);
    }

    @Override
    public ProductResource publish(String accessToken, ProductResource object) {
        return this.publishObject(accessToken, object, ProductResource.class);

    }
}
