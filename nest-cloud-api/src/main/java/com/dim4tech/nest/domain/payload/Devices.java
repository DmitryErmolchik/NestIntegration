package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Devices {
    public final static String THERMOSTATS = "thermostats";
    /* Thermostats in the structure */
    private final Thermostats thermostats;

    public final static String SMOKE_CO_ALARMS = "smoke_co_alarms";
    /* Smoke + CO alarms in the structure */
    private final SmokeCoAlarms smokeCoAlarms;

    public final static String CAMERAS= "cameras";
    /* Cameras in the structure */
    private final Cameras cameras;

    private final static String COMPANY = "company";
    /* A variable provided by Nest when you create a client with Product data read/write permissions.
        Identifies your company as an entity that can share product data with the Nest service. */
    private final Map<String, ProductType> company;

    @JsonCreator
    public Devices(@JsonProperty(THERMOSTATS) Thermostats thermostats,
                   @JsonProperty(SMOKE_CO_ALARMS) SmokeCoAlarms smokeCoAlarms,
                   @JsonProperty(CAMERAS) Cameras cameras,
                   @JsonProperty(COMPANY) Map<String, ProductType> company) {
        this.thermostats = thermostats;
        this.smokeCoAlarms = smokeCoAlarms;
        this.cameras = cameras;
        this.company = company;
    }

    public Thermostats getThermostats() {
        return thermostats;
    }

    public SmokeCoAlarms getSmokeCoAlarms() {
        return smokeCoAlarms;
    }

    public Cameras getCameras() {
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
