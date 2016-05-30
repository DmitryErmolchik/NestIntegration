package com.dim4tech.nest.domain.payload;

import java.util.Objects;

public class Identification {
    /* Unique device identifier for your product. */
    private final DeviceId deviceId;

    /* Serial number of your product or device. */
    private final String serialNumber;


    public Identification(DeviceId deviceId,
                          String serialNumber) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
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
