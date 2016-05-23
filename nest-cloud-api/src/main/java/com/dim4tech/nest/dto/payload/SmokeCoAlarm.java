package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.dto.payload.constants.AlarmState;
import com.dim4tech.nest.dto.payload.constants.BatteryHealth;
import com.dim4tech.nest.dto.payload.constants.UiColorState;
import com.dim4tech.nest.helper.LocaleHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.Locale;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmokeCoAlarm {
    private final static String DEVICE_ID = "device_id";
    /* Smoke+CO alarm unique identifier */
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

    private final static String BATTERY_HEALTH = "battery_health";
    /* Battery life/health; estimate of time to end of life */
    private final BatteryHealth batteryHealth;

    private final static String CO_ALARM_STATE = "co_alarm_state";
    /* CO alarm status */
    private final AlarmState coAlarmState;

    private final static String SMOKE_ALARM_STATE = "smoke_alarm_state";
    /* Smoke alarm status */
    private final AlarmState smokeAlarmState;

    private final static String IS_MANUAL_TEST_ACTIVE = "is_manual_test_active";
    /* State of the manual smoke and CO alarm test. */
    private final boolean isManualTestActive;

    private final static String LAST_MANUAL_TEST_TIME = "last_manual_test_time";
    /* Timestamp of the last successful manual test, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime lastManualTestTime;

    private final static String UI_COLOR_STATE = "ui_color_state";
    /* Indicates device status by color in the Nest app UI; it is an aggregate condition for battery+smoke+co states,
        and reflects the actual color indicators displayed in the Nest app */
    private final UiColorState uiColorState;

    private final static String WHERE_ID = "where_id";
    /* Where unique identifier. */
    private final WhereId whereId;

    @JsonCreator
    public SmokeCoAlarm(@JsonProperty(DEVICE_ID) DeviceId deviceId,
                        @JsonProperty(LOCALE) Locale locale,
                        @JsonProperty(SOFTWARE_VERSION) String softwareVersion,
                        @JsonProperty(STRUCTURE_ID) StructureId structureId,
                        @JsonProperty(NAME) String name,
                        @JsonProperty(NAME_LONG) String nameLong,
                        @JsonProperty(LAST_CONNECTION) DateTime lastConnection,
                        @JsonProperty(IS_ONLINE) boolean isOnline,
                        @JsonProperty(BATTERY_HEALTH) BatteryHealth batteryHealth,
                        @JsonProperty(CO_ALARM_STATE) AlarmState coAlarmState,
                        @JsonProperty(SMOKE_ALARM_STATE) AlarmState smokeAlarmState,
                        @JsonProperty(IS_MANUAL_TEST_ACTIVE) boolean isManualTestActive,
                        @JsonProperty(LAST_MANUAL_TEST_TIME) DateTime lastManualTestTime,
                        @JsonProperty(UI_COLOR_STATE) UiColorState uiColorState,
                        @JsonProperty(WHERE_ID) WhereId whereId) {
        this.deviceId = deviceId;
        this.locale = LocaleHelper.convertLocale(locale);
        this.softwareVersion = softwareVersion;
        this.structureId = structureId;
        this.name = name;
        this.nameLong = nameLong;
        this.lastConnection = lastConnection;
        this.isOnline = isOnline;
        this.batteryHealth = batteryHealth;
        this.coAlarmState = coAlarmState;
        this.smokeAlarmState = smokeAlarmState;
        this.isManualTestActive = isManualTestActive;
        this.lastManualTestTime = lastManualTestTime;
        this.uiColorState = uiColorState;
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

    public BatteryHealth getBatteryHealth() {
        return batteryHealth;
    }

    public AlarmState getCoAlarmState() {
        return coAlarmState;
    }

    public AlarmState getSmokeAlarmState() {
        return smokeAlarmState;
    }

    public boolean isManualTestActive() {
        return isManualTestActive;
    }

    public DateTime getLastManualTestTime() {
        return lastManualTestTime;
    }

    public UiColorState getUiColorState() {
        return uiColorState;
    }

    public WhereId getWhereId() {
        return whereId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmokeCoAlarm that = (SmokeCoAlarm) o;
        return isOnline == that.isOnline &&
                isManualTestActive == that.isManualTestActive &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(locale, that.locale) &&
                Objects.equals(softwareVersion, that.softwareVersion) &&
                Objects.equals(structureId, that.structureId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(nameLong, that.nameLong) &&
                Objects.equals(lastConnection, that.lastConnection) &&
                batteryHealth == that.batteryHealth &&
                coAlarmState == that.coAlarmState &&
                smokeAlarmState == that.smokeAlarmState &&
                Objects.equals(lastManualTestTime, that.lastManualTestTime) &&
                uiColorState == that.uiColorState &&
                Objects.equals(whereId, that.whereId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, locale, softwareVersion, structureId, name, nameLong, lastConnection, isOnline, batteryHealth, coAlarmState, smokeAlarmState, isManualTestActive, lastManualTestTime, uiColorState, whereId);
    }
}
