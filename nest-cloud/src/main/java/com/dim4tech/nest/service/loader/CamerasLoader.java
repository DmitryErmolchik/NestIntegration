package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.Camera;
import com.dim4tech.nest.domain.payload.DeviceId;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URL;
import java.util.Map;

public class CamerasLoader extends AbstractLoader<Map<DeviceId, Camera>> {

    public CamerasLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public CamerasLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Map<DeviceId, Camera> load(String accessToken) {
        return loadJsonData(accessToken, new TypeReference<Map<DeviceId, Camera>>() {});
    }
}
