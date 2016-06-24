package com.dim4tech.nest.service.publisher;

import com.dim4tech.nest.domain.payload.Thermostat;

import java.net.URL;

public class ThermostatPublisher extends AbstractPublisher<Thermostat> {
    protected ThermostatPublisher(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    protected ThermostatPublisher(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Thermostat publish(String accessToken, Thermostat object) {
        return this.publishObject(accessToken, object, Thermostat.class);
    }
}
