package com.dim4tech.nest.domain.payload;

import java.util.Map;
import java.util.Objects;

public class SmokeCoAlarms {
    private final Map<DeviceId, SmokeCoAlarm> smokeCoAlarms;

    public SmokeCoAlarms(Map<DeviceId, SmokeCoAlarm> smokeCoAlarms) {
        this.smokeCoAlarms = smokeCoAlarms;
    }

    public Map<DeviceId, SmokeCoAlarm> getSmokeCoAlarms() {
        return smokeCoAlarms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmokeCoAlarms that = (SmokeCoAlarms) o;
        return Objects.equals(smokeCoAlarms, that.smokeCoAlarms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smokeCoAlarms);
    }
}
