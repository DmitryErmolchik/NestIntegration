package com.dim4tech.nest.domain.payload;

import java.util.Map;
import java.util.Objects;

public class Thermostats {
    private final Map<DeviceId, Thermostat> thermostats;

    public Thermostats(Map<DeviceId, Thermostat> thermostats) {
        this.thermostats = thermostats;
    }

    public Map<DeviceId, Thermostat> getThermostats() {
        return thermostats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thermostats that = (Thermostats) o;
        return Objects.equals(thermostats, that.thermostats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thermostats);
    }
}
