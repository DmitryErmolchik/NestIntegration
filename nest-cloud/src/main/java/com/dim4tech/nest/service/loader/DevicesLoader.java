package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.Devices;

import java.net.URL;

public class DevicesLoader extends AbstractLoader<Devices> {

    public DevicesLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public DevicesLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Devices load(String accessToken) {
        return loadJsonData(accessToken, Devices.class);
    }
}
