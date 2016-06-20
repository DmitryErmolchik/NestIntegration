package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.SmokeCoAlarm;

import java.net.URL;

public class SmokeCoAlarmLoader extends AbstractLoader<SmokeCoAlarm> {

    public SmokeCoAlarmLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public SmokeCoAlarmLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public SmokeCoAlarm load(String accessToken) {
        return loadJsonData(accessToken, SmokeCoAlarm.class);
    }
}
