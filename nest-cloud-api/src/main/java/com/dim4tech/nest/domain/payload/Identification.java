package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Identification {
    private final static String DEVICE_ID = "device_id";
    /* Unique device identifier for your product. */
    private final DeviceId deviceId;

    private final static String SERIAL_NUMBER = "serial_number";
    /* Serial number of your product or device. */
    private final String serialNumber;


    @JsonCreator
    public Identification(@JsonProperty(DEVICE_ID) DeviceId deviceId,
                          @JsonProperty(SERIAL_NUMBER) String serialNumber) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
    }

    public static Identification createFromJson(Map<String, String> identificationData) {
        String deviceId = null;
        String serialNumber = null;
        for (Map.Entry<String, String> entry : identificationData.entrySet()) {
            switch (entry.getKey()) {
                case DEVICE_ID:
                    deviceId = entry.getValue();
                    break;
                case SERIAL_NUMBER:
                    serialNumber = entry.getValue();
                    break;
            }
        }
        return new Identification(new DeviceId(deviceId), serialNumber);
    }

    public DeviceId getDeviceId() {
        return deviceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identification that = (Identification) o;
        return Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, serialNumber);
    }
}
