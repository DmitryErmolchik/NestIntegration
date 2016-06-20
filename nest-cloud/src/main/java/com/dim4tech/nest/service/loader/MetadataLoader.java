package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.Metadata;

import java.net.URL;

public class MetadataLoader extends AbstractLoader<Metadata> {

    public MetadataLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public MetadataLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Metadata load(String accessToken) {
        return loadJsonData(accessToken, Metadata.class);
    }
}
