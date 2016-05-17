package com.dim4tech.nest.dto.payload;

public class Identification {
    /* Unique device identifier for your product. */
    private final DeviceId deviceId;

    /* Serial number of your product or device. */
    private final String serialNumber;

    public Identification(DeviceId deviceId, String serialNumber) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
    }

    public DeviceId getDeviceId() {
        return deviceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
