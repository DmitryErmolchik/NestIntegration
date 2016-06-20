package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.NestData;

import java.net.URL;

public class NestDataLoader extends AbstractLoader<NestData> {

    public NestDataLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public NestDataLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public NestData load(String accessToken) {
        return loadJsonData(accessToken, NestData.class);
    }
}
