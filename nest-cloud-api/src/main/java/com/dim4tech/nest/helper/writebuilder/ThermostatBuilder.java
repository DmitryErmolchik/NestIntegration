package com.dim4tech.nest.helper.writebuilder;

import com.dim4tech.nest.domain.payload.Thermostat;
import com.dim4tech.nest.domain.payload.constant.HvacMode;
import com.dim4tech.nest.domain.payload.constant.TemperatureScale;

public class ThermostatBuilder {
    private boolean fanTimerActive;
    private TemperatureScale temperatureScale;
    private Double targetTemperatureF;
    private Double targetTemperatureC;
    private Double targetTemperatureHighF;
    private Double targetTemperatureHighC;
    private Double targetTemperatureLowF;
    private Double targetTemperatureLowC;
    private HvacMode hvacMode;
    private String label;

    public ThermostatBuilder setFanTimerActive(boolean fanTimerActive) {
        this.fanTimerActive = fanTimerActive;
        return this;
    }

    public ThermostatBuilder setTemperatureScale(TemperatureScale temperatureScale) {
        this.temperatureScale = temperatureScale;
        return this;
    }

    public ThermostatBuilder setTargetTemperatureF(Double targetTemperatureF) {
        this.targetTemperatureF = targetTemperatureF;
        return this;
    }

    public ThermostatBuilder setTargetTemperatureC(Double targetTemperatureC) {
        this.targetTemperatureC = targetTemperatureC;
        return this;
    }

    public ThermostatBuilder setTargetTemperatureHighF(Double targetTemperatureHighF) {
        this.targetTemperatureHighF = targetTemperatureHighF;
        return this;
    }

    public ThermostatBuilder setTargetTemperatureHighC(Double targetTemperatureHighC) {
        this.targetTemperatureHighC = targetTemperatureHighC;
        return this;
    }

    public ThermostatBuilder setTargetTemperatureLowF(Double targetTemperatureLowF) {
        this.targetTemperatureLowF = targetTemperatureLowF;
        return this;
    }

    public ThermostatBuilder setTargetTemperatureLowC(Double targetTemperatureLowC) {
        this.targetTemperatureLowC = targetTemperatureLowC;
        return this;
    }

    public ThermostatBuilder setHvacMode(HvacMode hvacMode) {
        this.hvacMode = hvacMode;
        return this;
    }

    public ThermostatBuilder setLabel(String label) {
        this.label = label;
        return this;
    }

    public Thermostat build() {
        return new Thermostat(null, null, null, null, null, null, null, null, null, null, null, null,
                fanTimerActive, null, null, temperatureScale, targetTemperatureF, targetTemperatureC,
                targetTemperatureHighF, targetTemperatureHighC, targetTemperatureLowF, targetTemperatureLowC,
                null, null, null, null, hvacMode, null, null, null, null, null, null, null, null,
                null, null, label);
    }
}
