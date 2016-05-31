package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.domain.payload.constants.HvacMode;
import com.dim4tech.nest.domain.payload.constants.HvacState;
import com.dim4tech.nest.domain.payload.constants.TemperatureScale;
import com.dim4tech.nest.helper.LocaleHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.Locale;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Thermostat {
    private final static String DEVICE_ID = "device_id";
    /* Thermostat unique identifier */
    private final DeviceId deviceId;

    private final static String LOCALE = "locale";
    /* Country and language preference, in IETF Language Tag (https://en.wikipedia.org/wiki/IETF_language_tag) format */
    private final Locale locale;

    private final static String SOFTWARE_VERSION ="software_version";
    /* Software version */
    private final String softwareVersion;

    private final static String STRUCTURE_ID = "structure_id";
    /* Unique structure identifier */
    private final StructureId structureId;

    private final static String NAME = "name";
    /* Display name of the device */
    private final String name;

    private final static String NAME_LONG = "name_long";
    /* Long display name of the device */
    private final String nameLong;

    private final static String LAST_CONNECTION = "last_connection";
    /* Time of the last successful interaction with the Nest service, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format */
    /* 2016-10-31T23:59:59.000Z */
    private final DateTime lastConnection;

    private final static String IS_ONLINE = "is_online";
    /* Device connection status with the Nest Service */
    private final boolean isOnline;

    private final static String CAN_COOL = "can_cool";
    /* System ability to cool (AC) */
    private final boolean canCool;

    private final static String CAN_HEAT = "can_heat";
    /* System ability to heat */
    private final boolean canHeat;

    private final static String IS_USING_EMERGENCY_HEAT = "is_using_emergency_heat";
    /* Emergency Heat status in systems with heat pumps */
    private final boolean isUsingEmergencyHeat;

    private final static String HAS_FAN = "has_fan";
    /* System ability to control the fan separately from heating or cooling */
    private final boolean hasFan;

    private final static String FAN_TIMER_ACTIVE = "fan_timer_active";
    /* Indicates if the fan timer is engaged; used with 'fan_timer_timeout' to turn on the fan for a (user-specified) preset duration */
    private final boolean fanTimerActive;

    private final static String FAN_TIMER_TIMEOUT = "fan_timer_timeout";
    /* Timestamp, showing when the fan timer reaches 0 (end of timer duration), in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format */
    private final DateTime fanTimerTimeout;

    private final static String HAS_LEAF = "has_leaf";
    /* Displayed when users choose an energy-saving temperature */
    private final boolean hasLeaf;

    private final static String TEMPERATURE_SCALE = "temperature_scale";
    /* Celsius or Fahrenheit; used with temperature display */
    private final TemperatureScale temperatureScale;

    private final static String TARGET_TEMPERATURE_F = "target_temperature_f";
    /* Desired temperature, displayed in whole degrees Fahrenheit (1°F) */
    private final double targetTemperatureF;

    private final static String TARGET_TEMPERATURE_C = "target_temperature_c";
    /* Desired temperature, displayed in half degrees Celsius (0.5°C) */
    private final double targetTemperatureC;

    private final static String TARGET_TEMPERATURE_HIGH_F = "target_temperature_high_f";
    /* Maximum target temperature, displayed in whole degrees Fahrenheit (1°F); used with Heat • Cool mode */
    private final double targetTemperatureHighF;

    private final static String TARGET_TEMPERATURE_HIGH_C = "target_temperature_high_c";
    /* Maximum target temperature, displayed in half degrees Celsius (0.5°C); used with Heat • Cool mode */
    private final double targetTemperatureHighC;

    private final static String TARGET_TEMPERATURE_LOW_F = "target_temperature_low_f";
    /* Minimum target temperature, displayed in whole degrees Fahrenheit (1°F); used with Heat • Cool mode */
    private final double targetTemperatureLowF;

    private final static String TARGET_TEMPERATURE_LOW_C = "target_temperature_low_c";
    /* Minimum target temperature, displayed in half degrees Celsius (0.5°C); used with Heat • Cool mode */
    private final double targetTemperatureLowC;

    private final static String AWAY_TEMPERATURE_HIGH_F = "away_temperature_high_f";
    /* Maximum 'away' temperature, displayed in whole degrees Fahrenheit (1°F) */
    private final double awayTemperatureHighF;

    private final static String AWAY_TEMPERATURE_HIGH_C = "away_temperature_high_c";
    /* Maximum 'away' temperature, displayed in half degrees Celsius (0.5°C) */
    private final double awayTemperatureHighC;

    private final static String AWAY_TEMPERATURE_LOW_F = "away_temperature_low_f";
    /* Minimum 'away' temperature, displayed in whole degrees Fahrenheit (1°F) */
    private final double awayTemperatureLowF;

    private final static String AWAY_TEMPERATURE_LOW_C = "away_temperature_low_c";
    /* Minimum 'away' temperature, displayed in half degrees Celsius (0.5°C) */
    private final double awayTemperatureLowC;

    private final static String HVAC_MODE = "hvac_mode";
    /* Indicates HVAC system heating/cooling modes; for systems with both heating and cooling capability,
        use 'heat-cool': (Heat • Cool mode) */
    private final HvacMode hvacMode;

    private final static String AMBIENT_TEMPERATURE_F = "ambient_temperature_f";
    /* Temperature, measured at the device, in whole degrees Fahrenheit (1°f) */
    private final double ambientTemperatureF;

    private final static String AMBIENT_TEMPERATURE_C = "ambient_temperature_c";
    /* Temperature, measured at the device, in half degrees Celsius (0.5°C) */
    private final double ambientTemperatureC;

    private final static String HUMIDITY = "humidity";
    /* Humidity, in percent (%) format, measured at the device. */
    private final double humidity;

    private final static String HVAC_STATE = "hvac_state";
    /* Indicates whether the HVAC system is actively heating, cooling or is off */
    private final HvacState hvacState;

    private final static String WHERE_ID = "where_id";
    /* Where unique identifier. */
    private final WhereId whereId;

    private final static String IS_LOCKED = "is_locked";
    /* Thermostat Lock status. When true, the Thermostat Lock feature is enabled,
        and restricts the temperature range to these min/max values:
        locked_temp_min_f, locked_temp_max_f, locked_temp_min_c, and locked_temp_max_c. */
    private final boolean isLocked;

    private final static String LOCKED_TEMP_MIN_F = "locked_temp_min_f";
    /* Minimum Thermostat Lock temperature, displayed in whole degrees Fahrenheit (1°F).
        Used when is_locked is true. */
    private final String lockedTempMinF;

    private final static String LOCKED_TEMP_MAX_F = "locked_temp_max_f";
    /* Maximum Thermostat Lock temperature, displayed in whole degrees Fahrenheit (1°F).
        Used when is_locked is true. */
    private final String lockedTempMaxF;

    private final static String LOCKED_TEMP_MIN_C = "locked_temp_min_c";
    /* Minimum Thermostat Lock temperature, displayed in half degrees Celsius (0.5°C).
        Used when is_locked is true. */
    private final String lockedTempMinC;

    private final static String LOCKED_TEMP_MAX_C = "locked_temp_max_c";
    /* Maximum Thermostat Lock temperature, displayed in half degrees Celsius (0.5°C).
    Used when is_locked is true. */
    private final String lockedTempMaxC;

    private final static String LABEL = "label";
    /* Thermostat custom label. */
    private final String label;

    @JsonCreator
    public Thermostat(@JsonProperty(DEVICE_ID) DeviceId deviceId,
                      @JsonProperty(LOCALE) Locale locale,
                      @JsonProperty(SOFTWARE_VERSION) String softwareVersion,
                      @JsonProperty(STRUCTURE_ID) StructureId structureId,
                      @JsonProperty(NAME) String name,
                      @JsonProperty(NAME_LONG) String nameLong,
                      @JsonProperty(LAST_CONNECTION) DateTime lastConnection,
                      @JsonProperty(IS_ONLINE) boolean isOnline,
                      @JsonProperty(CAN_COOL) boolean canCool,
                      @JsonProperty(CAN_HEAT) boolean canHeat,
                      @JsonProperty(IS_USING_EMERGENCY_HEAT) boolean isUsingEmergencyHeat,
                      @JsonProperty(HAS_FAN) boolean hasFan,
                      @JsonProperty(FAN_TIMER_ACTIVE) boolean fanTimerActive,
                      @JsonProperty(FAN_TIMER_TIMEOUT) DateTime fanTimerTimeout,
                      @JsonProperty(HAS_LEAF) boolean hasLeaf,
                      @JsonProperty(TEMPERATURE_SCALE) TemperatureScale temperatureScale,
                      @JsonProperty(TARGET_TEMPERATURE_F) double targetTemperatureF,
                      @JsonProperty(TARGET_TEMPERATURE_C) double targetTemperatureC,
                      @JsonProperty(TARGET_TEMPERATURE_HIGH_F) double targetTemperatureHighF,
                      @JsonProperty(TARGET_TEMPERATURE_HIGH_C) double targetTemperatureHighC,
                      @JsonProperty(TARGET_TEMPERATURE_LOW_F) double targetTemperatureLowF,
                      @JsonProperty(TARGET_TEMPERATURE_LOW_C) double targetTemperatureLowC,
                      @JsonProperty(AWAY_TEMPERATURE_HIGH_F) double awayTemperatureHighF,
                      @JsonProperty(AWAY_TEMPERATURE_HIGH_C) double awayTemperatureHighC,
                      @JsonProperty(AWAY_TEMPERATURE_LOW_F) double awayTemperatureLowF,
                      @JsonProperty(AWAY_TEMPERATURE_LOW_C) double awayTemperatureLowC,
                      @JsonProperty(HVAC_MODE) HvacMode hvacMode,
                      @JsonProperty(AMBIENT_TEMPERATURE_F) double ambientTemperatureF,
                      @JsonProperty(AMBIENT_TEMPERATURE_C) double ambientTemperatureC,
                      @JsonProperty(HUMIDITY) double humidity,
                      @JsonProperty(HVAC_STATE) HvacState hvacState,
                      @JsonProperty(WHERE_ID) WhereId whereId,
                      @JsonProperty(IS_LOCKED) boolean isLocked,
                      @JsonProperty(LOCKED_TEMP_MIN_F) String lockedTempMinF,
                      @JsonProperty(LOCKED_TEMP_MAX_F) String lockedTempMaxF,
                      @JsonProperty(LOCKED_TEMP_MIN_C) String lockedTempMinC,
                      @JsonProperty(LOCKED_TEMP_MAX_C) String lockedTempMaxC,
                      @JsonProperty(LABEL) String label) {
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
