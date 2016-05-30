package com.dim4tech.nest.domain.payload;

import com.dim4tech.nest.domain.payload.constants.AwayState;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

public class Structure {
    /* Unique structure identifier */
    private final StructureId structureId;

    /* Array of Thermostats in the structure, by unique identifier */
    private final List<DeviceId> thermostats;

    /* Array of smoke+CO alarms in the structure, by unique identifier */
    private final List<DeviceId> smokeCoAlarms;

    /* List of cameras in the structure, by unique device identifier.
        This is an array of JSON objects that includes all cameras in the structure. */
    private final List<DeviceId> cameras;

    /* Devices */
    private final StructureDevices devices;

    /* Describes the Structure state; see the Away Guide for more information */
    private final AwayState away;

    /* User-defined structure name; defaults to 'Home' if the structure type is 'home' */
    private final String name;

    /* Country, in ISO 3166-1 alpha-2 (http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) format */
    private final String countryCode;

    /* Postal/zip code. */
    private final String postalCode;

    /* Start time of Rush Hour Rewards energy event, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format */
    private final DateTime peakPeriodStartTime;

    /* End time of Rush Hour Rewards energy event, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format */
    private final DateTime peakPeriodEndTime;

    /* Time zone at the structure, in IANA (http://www.iana.org/time-zones) time zone format */
    private final TimeZone timeZone;

    /* Used to let Nest know that a user is expected to return home at a specific time.
        Requires a series of calls. All three contained fields are required when supplying 'eta'.
        Learn more: ETA Guide (https://developers.nest.com/documentation/cloud/eta-guide) */
    private final Eta eta;

    /* Rush Hour Rewards enrollment status */
    private final Boolean rhrEnrollment;

    /* An object containing where identifiers for devices in the structure. */
    private final Map<WhereId, Where> wheres;

    public Structure(StructureId structureId,
            List<DeviceId> thermostats,
            List<DeviceId> smokeCoAlarms,
            List<DeviceId> cameras,
            StructureDevices devices,
            AwayState away,
            String name,
            String countryCode,
            String postalCode,
            DateTime peakPeriodStartTime,
            DateTime peakPeriodEndTime,
            TimeZone timeZone,
            Eta eta,
            Boolean rhrEnrollment,
            Map<WhereId, Where> wheres) {
        this.structureId = structureId;
        this.thermostats = thermostats;
        this.smokeCoAlarms = smokeCoAlarms;
        this.cameras = cameras;
        this.devices = devices;
        this.away = away;
        this.name = name;
        this.countryCode = countryCode;
        this.postalCode = postalCode;
        this.peakPeriodStartTime = peakPeriodStartTime;
        this.peakPeriodEndTime = peakPeriodEndTime;
        this.timeZone = timeZone;
        this.eta = eta;
        this.rhrEnrollment = rhrEnrollment;
        this.wheres = wheres;
    }

    public StructureId getStructureId() {
        return structureId;
    }

    public List<DeviceId> getThermostats() {
        return thermostats;
    }

    public List<DeviceId> getSmokeCoAlarms() {
        return smokeCoAlarms;
    }

    public List<DeviceId> getCameras() {
        return cameras;
    }

    public StructureDevices getDevices() {
        return devices;
    }

    public AwayState getAway() {
        return away;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public DateTime getPeakPeriodStartTime() {
        return new DateTime(peakPeriodStartTime);
    }

    public DateTime getPeakPeriodEndTime() {
        return new DateTime(peakPeriodEndTime);
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public Eta getEta() {
        return eta;
    }

    public Boolean isRhrEnrollment() {
        return rhrEnrollment;
    }

    public Map<WhereId, Where> getWheres() {
        return wheres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Structure structure = (Structure) o;
        return rhrEnrollment == structure.rhrEnrollment &&
                Objects.equals(structureId, structure.structureId) &&
                Objects.equals(thermostats, structure.thermostats) &&
                Objects.equals(smokeCoAlarms, structure.smokeCoAlarms) &&
                Objects.equals(cameras, structure.cameras) &&
                Objects.equals(devices, structure.devices) &&
                away == structure.away &&
                Objects.equals(name, structure.name) &&
                Objects.equals(countryCode, structure.countryCode) &&
                Objects.equals(postalCode, structure.postalCode) &&
                Objects.equals(peakPeriodStartTime, structure.peakPeriodStartTime) &&
                Objects.equals(peakPeriodEndTime, structure.peakPeriodEndTime) &&
                Objects.equals(timeZone, structure.timeZone) &&
                Objects.equals(eta, structure.eta) &&
                Objects.equals(wheres, structure.wheres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structureId, thermostats, smokeCoAlarms, cameras, devices, away, name, countryCode, postalCode, peakPeriodStartTime, peakPeriodEndTime, timeZone, eta, rhrEnrollment, wheres);
    }
}
