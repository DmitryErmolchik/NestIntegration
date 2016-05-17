package com.dim4tech.nest.dto.payload;

import java.util.Map;

public class Devices {
    /* Thermostats in the structure */
    private final Map<DeviceId, Thermostat> thermostats;

    /* Smoke + CO alarms in the structure */
    private final Map<DeviceId, SmokeCoAlarm> smokeCoAlarms;

    /* Cameras in the structure */
    private final Map<DeviceId, Camera> cameras;

    /* A variable provided by Nest when you create a client with Product data read/write permissions.
        Identifies your company as an entity that can share product data with the Nest service. */
    private final Map<String, ProductType> company;

    public Devices(Map<DeviceId, Thermostat> thermostats, Map<DeviceId, SmokeCoAlarm> smokeCoAlarms,
                   Map<DeviceId, Camera> cameras, Map<String, ProductType> company) {
        this.thermostats = thermostats;
        this.smokeCoAlarms = smokeCoAlarms;
        this.cameras = cameras;
        this.company = company;
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
}
