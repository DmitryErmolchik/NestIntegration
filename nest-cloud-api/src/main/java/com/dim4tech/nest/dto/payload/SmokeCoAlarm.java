package com.dim4tech.nest.dto.payload;

import com.dim4tech.nest.dto.payload.constants.AlarmState;
import com.dim4tech.nest.dto.payload.constants.BatteryHealth;
import com.dim4tech.nest.dto.payload.constants.UiColorState;
import org.joda.time.DateTime;

import java.util.Locale;

public class SmokeCoAlarm {
    /* Smoke+CO alarm unique identifier */
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

    /* Battery life/health; estimate of time to end of life */
    private final BatteryHealth batteryHealth;

    /* CO alarm status */
    private final AlarmState coAlarmState;

    /* Smoke alarm status */
    private final AlarmState smokeAlarmState;

    /* State of the manual smoke and CO alarm test. */
    private final boolean isManualTestActive;

    /* Timestamp of the last successful manual test, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime lastManualTestTime;

    /* Indicates device status by color in the Nest app UI; it is an aggregate condition for battery+smoke+co states,
        and reflects the actual color indicators displayed in the Nest app */
    private final UiColorState uiColorState;

    /* Where unique identifier. */
    private final WhereId whereId;

    public SmokeCoAlarm(DeviceId deviceId, Locale locale, String softwareVersion, StructureId structureId, String name,
                        String nameLong, DateTime lastConnection, boolean isOnline, BatteryHealth batteryHealth,
                        AlarmState coAlarmState, AlarmState smokeAlarmState, boolean isManualTestActive,
                        DateTime lastManualTestTime, UiColorState uiColorState, WhereId whereId) {
        this.deviceId = deviceId;
        this.locale = locale;
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
}
