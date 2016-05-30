package com.dim4tech.nest.domain.payload;

import com.dim4tech.nest.domain.payload.constants.HvacMode;
import com.dim4tech.nest.domain.payload.constants.HvacState;
import com.dim4tech.nest.domain.payload.constants.TemperatureScale;
import com.dim4tech.nest.helper.LocaleHelper;
import org.joda.time.DateTime;

import java.util.Locale;
import java.util.Objects;

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
    private final boolean fanTimerActive;

    /* Timestamp, showing when the fan timer reaches 0 (end of timer duration), in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format */
    private final DateTime fanTimerTimeout;

    /* Displayed when users choose an energy-saving temperature */
    private final boolean hasLeaf;

    /* Celsius or Fahrenheit; used with temperature display */
    private final TemperatureScale temperatureScale;

    /* Desired temperature, displayed in whole degrees Fahrenheit (1°F) */
    private final double targetTemperatureF;

    /* Desired temperature, displayed in half degrees Celsius (0.5°C) */
    private final double targetTemperatureC;

    /* Maximum target temperature, displayed in whole degrees Fahrenheit (1°F); used with Heat • Cool mode */
    private final double targetTemperatureHighF;

    /* Maximum target temperature, displayed in half degrees Celsius (0.5°C); used with Heat • Cool mode */
    private final double targetTemperatureHighC;

    /* Minimum target temperature, displayed in whole degrees Fahrenheit (1°F); used with Heat • Cool mode */
    private final double targetTemperatureLowF;

    /* Minimum target temperature, displayed in half degrees Celsius (0.5°C); used with Heat • Cool mode */
    private final double targetTemperatureLowC;

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
    private final HvacMode hvacMode;

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

    /* Thermostat Lock status. When true, the Thermostat Lock feature is enabled,
        and restricts the temperature range to these min/max values:
        locked_temp_min_f, locked_temp_max_f, locked_temp_min_c, and locked_temp_max_c. */
    private final boolean isLocked;

    /* Minimum Thermostat Lock temperature, displayed in whole degrees Fahrenheit (1°F).
        Used when is_locked is true. */
    private final String lockedTempMinF;

    /* Maximum Thermostat Lock temperature, displayed in whole degrees Fahrenheit (1°F).
        Used when is_locked is true. */
    private final String lockedTempMaxF;

    /* Minimum Thermostat Lock temperature, displayed in half degrees Celsius (0.5°C).
        Used when is_locked is true. */
    private final String lockedTempMinC;

    /* Maximum Thermostat Lock temperature, displayed in half degrees Celsius (0.5°C).
    Used when is_locked is true. */
    private final String lockedTempMaxC;

    /* Thermostat custom label. */
    private final String label;

    public Thermostat(DeviceId deviceId,
                      Locale locale,
                      String softwareVersion,
                      StructureId structureId,
                      String name,
                      String nameLong,
                      DateTime lastConnection,
                      boolean isOnline,
                      boolean canCool,
                      boolean canHeat,
                      boolean isUsingEmergencyHeat,
                      boolean hasFan,
                      boolean fanTimerActive,
                      DateTime fanTimerTimeout,
                      boolean hasLeaf,
                      TemperatureScale temperatureScale,
                      double targetTemperatureF,
                      double targetTemperatureC,
                      double targetTemperatureHighF,
                      double targetTemperatureHighC,
                      double targetTemperatureLowF,
                      double targetTemperatureLowC,
                      double awayTemperatureHighF,
                      double awayTemperatureHighC,
                      double awayTemperatureLowF,
                      double awayTemperatureLowC,
                      HvacMode hvacMode,
                      double ambientTemperatureF,
                      double ambientTemperatureC,
                      double humidity,
                      HvacState hvacState,
                      WhereId whereId,
                      boolean isLocked,
                      String lockedTempMinF,
                      String lockedTempMaxF,
                      String lockedTempMinC,
                      String lockedTempMaxC,
                      String label) {
        this.deviceId = deviceId;
        this.locale = LocaleHelper.convertLocale(locale);
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
        this.hvacMode = hvacMode;
        this.ambientTemperatureF = ambientTemperatureF;
        this.ambientTemperatureC = ambientTemperatureC;
        this.humidity = humidity;
        this.hvacState = hvacState;
        this.whereId = whereId;
        this.isLocked = isLocked;
        this.lockedTempMinF = lockedTempMinF;
        this.lockedTempMaxF = lockedTempMaxF;
        this.lockedTempMinC = lockedTempMinC;
        this.lockedTempMaxC = lockedTempMaxC;
        this.label = label;
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
        return new DateTime(lastConnection);
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

    public DateTime getFanTimerTimeout() {
        return new DateTime(fanTimerTimeout);
    }

    public boolean isHasLeaf() {
        return hasLeaf;
    }

    public TemperatureScale getTemperatureScale() {
        return temperatureScale;
    }

    public double getTargetTemperatureF() {
        return targetTemperatureF;
    }

    public double getTargetTemperatureC() {
        return targetTemperatureC;
    }

    public double getTargetTemperatureLowC() {
        return targetTemperatureLowC;
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

    public HvacMode getHvacMode() {
        return hvacMode;
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

    public boolean isLocked() {
        return isLocked;
    }

    public String getLockedTempMinF() {
        return lockedTempMinF;
    }

    public String getLockedTempMaxF() {
        return lockedTempMaxF;
    }

    public String getLockedTempMinC() {
        return lockedTempMinC;
    }

    public String getLockedTempMaxC() {
        return lockedTempMaxC;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thermostat that = (Thermostat) o;
        return isOnline == that.isOnline &&
                canCool == that.canCool &&
                canHeat == that.canHeat &&
                isUsingEmergencyHeat == that.isUsingEmergencyHeat &&
                hasFan == that.hasFan &&
                fanTimerActive == that.fanTimerActive &&
                hasLeaf == that.hasLeaf &&
                Double.compare(that.targetTemperatureF, targetTemperatureF) == 0 &&
                Double.compare(that.targetTemperatureC, targetTemperatureC) == 0 &&
                Double.compare(that.targetTemperatureHighF, targetTemperatureHighF) == 0 &&
                Double.compare(that.targetTemperatureHighC, targetTemperatureHighC) == 0 &&
                Double.compare(that.targetTemperatureLowF, targetTemperatureLowF) == 0 &&
                Double.compare(that.targetTemperatureLowC, targetTemperatureLowC) == 0 &&
                Double.compare(that.awayTemperatureHighF, awayTemperatureHighF) == 0 &&
                Double.compare(that.awayTemperatureHighC, awayTemperatureHighC) == 0 &&
                Double.compare(that.awayTemperatureLowF, awayTemperatureLowF) == 0 &&
                Double.compare(that.awayTemperatureLowC, awayTemperatureLowC) == 0 &&
                Double.compare(that.ambientTemperatureF, ambientTemperatureF) == 0 &&
                Double.compare(that.ambientTemperatureC, ambientTemperatureC) == 0 &&
                Double.compare(that.humidity, humidity) == 0 &&
                isLocked == that.isLocked &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(locale, that.locale) &&
                Objects.equals(softwareVersion, that.softwareVersion) &&
                Objects.equals(structureId, that.structureId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(nameLong, that.nameLong) &&
                Objects.equals(lastConnection, that.lastConnection) &&
                Objects.equals(fanTimerTimeout, that.fanTimerTimeout) &&
                temperatureScale == that.temperatureScale &&
                hvacMode == that.hvacMode &&
                hvacState == that.hvacState &&
                Objects.equals(whereId, that.whereId) &&
                Objects.equals(lockedTempMinF, that.lockedTempMinF) &&
                Objects.equals(lockedTempMaxF, that.lockedTempMaxF) &&
                Objects.equals(lockedTempMinC, that.lockedTempMinC) &&
                Objects.equals(lockedTempMaxC, that.lockedTempMaxC) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, locale, softwareVersion, structureId, name, nameLong, lastConnection, isOnline, canCool, canHeat, isUsingEmergencyHeat, hasFan, fanTimerActive, fanTimerTimeout, hasLeaf, temperatureScale, targetTemperatureF, targetTemperatureC, targetTemperatureHighF, targetTemperatureHighC, targetTemperatureLowF, targetTemperatureLowC, awayTemperatureHighF, awayTemperatureHighC, awayTemperatureLowF, awayTemperatureLowC, hvacMode, ambientTemperatureF, ambientTemperatureC, humidity, hvacState, whereId, isLocked, lockedTempMinF, lockedTempMaxF, lockedTempMinC, lockedTempMaxC, label);
    }
}
