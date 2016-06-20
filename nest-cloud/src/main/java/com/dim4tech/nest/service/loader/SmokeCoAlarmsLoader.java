package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.DeviceId;
import com.dim4tech.nest.domain.payload.SmokeCoAlarm;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URL;
import java.util.Map;

public class SmokeCoAlarmsLoader extends AbstractLoader<Map<DeviceId, SmokeCoAlarm>> {

    public SmokeCoAlarmsLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public SmokeCoAlarmsLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Map<DeviceId, SmokeCoAlarm> load(String accessToken) {
        return loadJsonData(accessToken, new TypeReference<Map<DeviceId, SmokeCoAlarm>>() {});
    }
}
