package com.dim4tech.nest.domain.payload;

import java.util.Map;
import java.util.Objects;

public class Cameras {
    private final Map<DeviceId, Camera> cameras;

    public Cameras(Map<DeviceId, Camera> cameras) {
        this.cameras = cameras;
    }

    public Map<DeviceId, Camera> getCameras() {
        return cameras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cameras cameras1 = (Cameras) o;
        return Objects.equals(cameras, cameras1.cameras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cameras);
    }
}
