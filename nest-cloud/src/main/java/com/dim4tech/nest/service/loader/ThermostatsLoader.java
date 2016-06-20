package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.DeviceId;
import com.dim4tech.nest.domain.payload.Thermostat;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URL;
import java.util.Map;

public class ThermostatsLoader extends AbstractLoader<Map<DeviceId, Thermostat>> {

    public ThermostatsLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public ThermostatsLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Map<DeviceId, Thermostat> load(String accessToken) {
        return loadJsonData(accessToken, new TypeReference<Map<DeviceId, Thermostat>>() {});
    }
}
