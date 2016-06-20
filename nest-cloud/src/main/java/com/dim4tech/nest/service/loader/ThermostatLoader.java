package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.Thermostat;

import java.net.URL;

public class ThermostatLoader extends AbstractLoader<Thermostat> {

    public ThermostatLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public ThermostatLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Thermostat load(String accessToken) {
        return loadJsonData(accessToken, Thermostat.class);
    }
}
