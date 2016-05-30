package com.dim4tech.nest.domain.payload;

import com.dim4tech.nest.domain.payload.constants.AlarmState;
import com.dim4tech.nest.domain.payload.constants.BatteryHealth;
import com.dim4tech.nest.domain.payload.constants.UiColorState;
import com.dim4tech.nest.helper.LocaleHelper;
import org.joda.time.DateTime;

import java.util.Locale;
import java.util.Objects;

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

    public SmokeCoAlarm(DeviceId deviceId,
                        Locale locale,
                        String softwareVersion,
                        StructureId structureId,
                        String name,
                        String nameLong,
                        DateTime lastConnection,
                        Boolean isOnline,
                        BatteryHealth batteryHealth,
                        AlarmState coAlarmState,
                        AlarmState smokeAlarmState,
                        Boolean isManualTestActive,
                        DateTime lastManualTestTime,
                        UiColorState uiColorState,
                        WhereId whereId) {
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
        return new DateTime(lastConnection);
    }

    public Boolean isOnline() {
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

    public Boolean isManualTestActive() {
        return isManualTestActive;
    }

    public DateTime getLastManualTestTime() {
        return new DateTime(lastManualTestTime);
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
