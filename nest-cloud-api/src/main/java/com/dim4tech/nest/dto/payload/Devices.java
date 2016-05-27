package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Devices {
    private final static String THERMOSTATS = "thermostats";
    /* Thermostats in the structure */
    private final Map<DeviceId, Thermostat> thermostats;

    private final static String SMOKE_CO_ALARMS = "smoke_co_alarms";
    /* Smoke + CO alarms in the structure */
    private final Map<DeviceId, SmokeCoAlarm> smokeCoAlarms;

    private final static String CAMERAS= "cameras";
    /* Cameras in the structure */
    private final Map<DeviceId, Camera> cameras;

    private final static String COMPANY = "company";
    /* A variable provided by Nest when you create a client with Product data read/write permissions.
        Identifies your company as an entity that can share product data with the Nest service. */
    private final Map<String, ProductType> company;

    public Devices() {
        this.thermostats = null;
        this.smokeCoAlarms = null;
        this.cameras = null;
        this.company = null;
    }

    public Devices(
            Map<DeviceId, Thermostat> thermostats,
            Map<DeviceId, SmokeCoAlarm> smokeCoAlarms,
            Map<DeviceId, Camera> cameras,
            Map<String, ProductType> company) {
        this.thermostats = thermostats;
        this.smokeCoAlarms = smokeCoAlarms;
        this.cameras = cameras;
        this.company = company;
    }

    @JsonCreator
    private static Devices createFromJson(Map<String, Object> devices) {
        return new Devices();
    }

    public Map<DeviceId, Thermostat> getThermostats() {
        return thermostats;
    }

    public Map<DeviceId, SmokeCoAlarm> getSmokeCoAlarms() {
        return smokeCoAlarms;
    }

    public Map<DeviceId, Camera> getCameras() {
        return cameras;
    }

    public Map<String, ProductType> getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devices devices = (Devices) o;
        return Objects.equals(thermostats, devices.thermostats) &&
                Objects.equals(smokeCoAlarms, devices.smokeCoAlarms) &&
                Objects.equals(cameras, devices.cameras) &&
                Objects.equals(company, devices.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thermostats, smokeCoAlarms, cameras, company);
    }
}
