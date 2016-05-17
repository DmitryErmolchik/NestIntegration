package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.dto.payload.constants.HvacMode;
import com.dim4tech.nest.dto.payload.constants.HvacState;
import com.dim4tech.nest.dto.payload.constants.TemperatureScale;
import org.joda.time.DateTime;

import java.util.Locale;

public class Thermostat {
    /* Thermostat unique identifier */
    private final DeviceId deviceId;

    /* Country and language preference, in IETF Language Tag (https://en.wikipedia.org/wiki/IETF_language_tag) format */
    private final Locale locale;

    /* Software version */
    private final String softwareVersion;

    /* Unique structure identifier */
    private final StructureId structureId;

    /* Display name of the device */
    private final String name;

    /* Long display name of the device */
    private final String nameLong;

    /* Time of the last successful interaction with the Nest service, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format */
    /* 2016-10-31T23:59:59.000Z */
    private final DateTime lastConnection;

    /* Device connection status with the Nest Service */
    private final boolean isOnline;

    /* System ability to cool (AC) */
    private final boolean canCool;

    /* System ability to heat */
    private final boolean canHeat;

    /* Emergency Heat status in systems with heat pumps */
    private final boolean isUsingEmergencyHeat;

    /* System ability to control the fan separately from heating or cooling */
    private final boolean hasFan;

    /* Indicates if the fan timer is engaged; used with 'fan_timer_timeout' to turn on the fan for a (user-specified) preset duration */
    private boolean fanTimerActive;

    /* Timestamp, showing when the fan timer reaches 0 (end of timer duration), in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format */
    private final DateTime fanTimerTimeout;

    /* Displayed when users choose an energy-saving temperature */
    private final boolean hasLeaf;

    /* Celsius or Fahrenheit; used with temperature display */
    private TemperatureScale temperatureScale;

    /* Desired temperature, displayed in whole degrees Fahrenheit (1°F) */
    private double targetTemperatureF;

    /* Desired temperature, displayed in half degrees Celsius (0.5°C) */
    private double targetTemperatureC;

    /* Maximum target temperature, displayed in whole degrees Fahrenheit (1°F); used with Heat • Cool mode */
    private double targetTemperatureHighF;

    /* Maximum target temperature, displayed in half degrees Celsius (0.5°C); used with Heat • Cool mode */
    private double targetTemperatureHighC;

    /* Minimum target temperature, displayed in whole degrees Fahrenheit (1°F); used with Heat • Cool mode */
    private double targetTemperatureLowF;

    /* Minimum target temperature, displayed in half degrees Celsius (0.5°C); used with Heat • Cool mode */
    private double targetTemperatureLowC;

    /* Maximum 'away' temperature, displayed in whole degrees Fahrenheit (1°F) */
    private final double awayTemperatureHighF;

    /* Maximum 'away' temperature, displayed in half degrees Celsius (0.5°C) */
    private final double awayTemperatureHighC;

    /* Minimum 'away' temperature, displayed in whole degrees Fahrenheit (1°F) */
    private final double awayTemperatureLowF;

    /* Minimum 'away' temperature, displayed in half degrees Celsius (0.5°C) */
    private final double awayTemperatureLowC;

    /* Indicates HVAC system heating/cooling modes; for systems with both heating and cooling capability,
        use 'heat-cool': (Heat • Cool mode) */
    private HvacMode hvac_mode;

    /* Temperature, measured at the device, in whole degrees Fahrenheit (1°f) */
    private final double ambientTemperatureF;

    /* Temperature, measured at the device, in half degrees Celsius (0.5°C) */
    private final double ambientTemperatureC;

    /* Humidity, in percent (%) format, measured at the device. */
    private final double humidity;

    /* Indicates whether the HVAC system is actively heating, cooling or is off */
    private final HvacState hvacState;

    /* Where unique identifier. */
    private final WhereId whereId;

    public Thermostat(DeviceId deviceId, Locale locale, String softwareVersion, StructureId structureId,
                      String name, String nameLong, DateTime lastConnection, boolean isOnline,
                      boolean canCool, boolean canHeat, boolean isUsingEmergencyHeat, boolean hasFan,
                      boolean fanTimerActive, DateTime fanTimerTimeout, boolean hasLeaf,
                      TemperatureScale temperatureScale, double targetTemperatureF, double targetTemperatureC,
                      double targetTemperatureHighF, double targetTemperatureHighC, double targetTemperatureLowF,
                      double targetTemperatureLowC, double awayTemperatureHighF, double awayTemperatureHighC,
                      double awayTemperatureLowF, double awayTemperatureLowC, HvacMode hvac_mode, double ambientTemperatureF,
                      double ambientTemperatureC, double humidity, HvacState hvacState, WhereId whereId) {
        this.deviceId = deviceId;
        this.locale = locale;
        this.softwareVersion = softwareVersion;
        this.structureId = structureId;
        this.name = name;
        this.nameLong = nameLong;
        this.lastConnection = lastConnection;
        this.isOnline = isOnline;
        this.canCool = canCool;
        this.canHeat = canHeat;
        this.isUsingEmergencyHeat = isUsingEmergencyHeat;
        this.hasFan = hasFan;
        this.fanTimerActive = fanTimerActive;
        this.fanTimerTimeout = fanTimerTimeout;
        this.hasLeaf = hasLeaf;
        this.temperatureScale = temperatureScale;
        this.targetTemperatureF = targetTemperatureF;
        this.targetTemperatureC = targetTemperatureC;
        this.targetTemperatureHighF = targetTemperatureHighF;
        this.targetTemperatureHighC = targetTemperatureHighC;
        this.targetTemperatureLowF = targetTemperatureLowF;
        this.targetTemperatureLowC = targetTemperatureLowC;
        this.awayTemperatureHighF = awayTemperatureHighF;
        this.awayTemperatureHighC = awayTemperatureHighC;
        this.awayTemperatureLowF = awayTemperatureLowF;
        this.awayTemperatureLowC = awayTemperatureLowC;
        this.hvac_mode = hvac_mode;
        this.ambientTemperatureF = ambientTemperatureF;
        this.ambientTemperatureC = ambientTemperatureC;
        this.humidity = humidity;
        this.hvacState = hvacState;
        this.whereId = whereId;
    }

    public DeviceId getDeviceId() {
        return deviceId;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public StructureId getStructureId() {
        return structureId;
    }

    public String getName() {
        return name;
    }

    public String getNameLong() {
        return nameLong;
    }

    public DateTime getLastConnection() {
        return lastConnection;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isCanCool() {
        return canCool;
    }

    public boolean isCanHeat() {
        return canHeat;
    }

    public boolean isUsingEmergencyHeat() {
        return isUsingEmergencyHeat;
    }

    public boolean isHasFan() {
        return hasFan;
    }

    public boolean isFanTimerActive() {
        return fanTimerActive;
    }

    public void setFanTimerActive(boolean fanTimerActive) {
        this.fanTimerActive = fanTimerActive;
    }

    public DateTime getFanTimerTimeout() {
        return fanTimerTimeout;
    }

    public boolean isHasLeaf() {
        return hasLeaf;
    }

    public TemperatureScale getTemperatureScale() {
        return temperatureScale;
    }

    public void setTemperatureScale(TemperatureScale temperatureScale) {
        this.temperatureScale = temperatureScale;
    }

    public double getTargetTemperatureF() {
        return targetTemperatureF;
    }

    public void setTargetTemperatureF(double targetTemperatureF) {
        this.targetTemperatureF = targetTemperatureF;
    }

    public double getTargetTemperatureC() {
        return targetTemperatureC;
    }

    public void setTargetTemperatureC(double targetTemperatureC) {
        this.targetTemperatureC = targetTemperatureC;
    }

    public double getTargetTemperatureHighF() {
        return targetTemperatureHighF;
    }

    public void setTargetTemperatureHighF(double targetTemperatureHighF) {
        this.targetTemperatureHighF = targetTemperatureHighF;
    }

    public double getTargetTemperatureHighC() {
        return targetTemperatureHighC;
    }

    public void setTargetTemperatureHighC(double targetTemperatureHighC) {
        this.targetTemperatureHighC = targetTemperatureHighC;
    }

    public double getTargetTemperatureLowF() {
        return targetTemperatureLowF;
    }

    public void setTargetTemperatureLowF(double targetTemperatureLowF) {
        this.targetTemperatureLowF = targetTemperatureLowF;
    }

    public double getTargetTemperatureLowC() {
        return targetTemperatureLowC;
    }

    public void setTargetTemperatureLowC(double targetTemperatureLowC) {
        this.targetTemperatureLowC = targetTemperatureLowC;
    }

    public double getAwayTemperatureHighF() {
        return awayTemperatureHighF;
    }

    public double getAwayTemperatureHighC() {
        return awayTemperatureHighC;
    }

    public double getAwayTemperatureLowF() {
        return awayTemperatureLowF;
    }

    public double getAwayTemperatureLowC() {
        return awayTemperatureLowC;
    }

    public HvacMode getHvac_mode() {
        return hvac_mode;
    }

    public void setHvac_mode(HvacMode hvac_mode) {
        this.hvac_mode = hvac_mode;
    }

    public double getAmbientTemperatureF() {
        return ambientTemperatureF;
    }

    public double getAmbientTemperatureC() {
        return ambientTemperatureC;
    }

    public double getHumidity() {
        return humidity;
    }

    public HvacState getHvacState() {
        return hvacState;
    }

    public WhereId getWhereId() {
        return whereId;
    }
}
