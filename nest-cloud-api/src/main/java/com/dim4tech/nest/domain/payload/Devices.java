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
    private final Map<DeviceId, Thermostat> thermostats;

    public final static String SMOKE_CO_ALARMS = "smoke_co_alarms";
    /* Smoke + CO alarms in the structure */
    private final Map<DeviceId, SmokeCoAlarm> smokeCoAlarms;

    public final static String CAMERAS= "cameras";
    /* Cameras in the structure */
    private final Map<DeviceId, Camera> cameras;

    private final static String COMPANY = "company";
    /* A variable provided by Nest when you create a client with Product data read/write permissions.
        Identifies your company as an entity that can share product data with the Nest service. */
    private final Map<String, ProductType> company;

    @JsonCreator
    public Devices(@JsonProperty(THERMOSTATS) Map<DeviceId, Thermostat> thermostats,
                   @JsonProperty(SMOKE_CO_ALARMS) Map<DeviceId, SmokeCoAlarm> smokeCoAlarms,
                   @JsonProperty(CAMERAS) Map<DeviceId, Camera> cameras,
                   @JsonProperty(COMPANY) Map<String, ProductType> company) {
        this.thermostats = thermostats;
        this.smokeCoAlarms = smokeCoAlarms;
        this.cameras = cameras;
        this.company = company;
    }

    /*@JsonCreator
    private static Devices createFromJson(Map<String, Object> devices) {
        Map<DeviceId, Thermostat> thermostats = new HashMap();
        Map<DeviceId, SmokeCoAlarm> smokeCoAlarms = new HashMap<>();
        Map<DeviceId, Camera> cameras = new HashMap<>();
        Map<String, ProductType> company = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JodaModule());

        for (Map.Entry<String, Object> entry : devices.entrySet()) {
            switch (entry.getKey()) {
                case THERMOSTATS:
                    try {
                        thermostats = objectMapper.readValue(objectMapper.writeValueAsString(entry.getValue()), new TypeReference<Map<DeviceId, Thermostat>>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case SMOKE_CO_ALARMS:
                    break;
                case CAMERAS:
                    break;
                default:
                    company.put(entry.getKey(), ProductType.createFromJson((Map<String, Object>) entry.getValue()));
                    break;
            }
        }

        thermostats = thermostats.size() == 0 ? null : thermostats;
        smokeCoAlarms = smokeCoAlarms.size() == 0 ? null :  smokeCoAlarms;
        cameras = cameras.size() == 0 ? null :  cameras;
        company = company.size() == 0 ? null :  company;

        return new Devices(thermostats, smokeCoAlarms, cameras, company);
    }*/

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
