package com.dim4tech.nest.domain.payload;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Camera {
    /* Camera unique identifier */
    private final DeviceId deviceId;

    /* Software version */
    private final String softwareVersion;

    /* Unique structure identifier */
    private final StructureId structureId;

    /* Where unique identifier. */
    private final WhereId whereId;

    /* Display name of the device */
    private final String name;

    /* Long display name of the device */
    private final String nameLong;

    /* Device connection status with the Nest Service */
    private final Boolean isOnline;

    /* Camera status, either on and actively streaming video, or off. */
    private final Boolean isStreaming;

    /* Camera microphone status, either on and listening, or off. */
    private final Boolean isAudioInputEnabled;

    /* Timestamp that identifies the last change to the online status,
        in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime lastIsOnlineChange;

    /* Nest Aware subscription status. */
    private final Boolean isVideoHistoryEnabled;

    /* Web URL (deep link) to the device page at home.nest.com. Used to display the camera live feed
        at that physical location (where). */
    private final String webUrl;

    /* App URL (deep link) to the device screen in the Nest App.
        Used to display the camera live feed at that physical location (where). */
    private final String appUrl;

    /* Users can choose to share their video and make it viewable by anyone.
        When public share is enabled, you can read public_share_url. */
    private final Boolean isPublicShareEnabled;

    /* Activity Zones are used to monitor motion events within user-defined areas of the video stream. */
    private final List<ActivityZone> activityZones;

    /* You can access this URL when a user makes their video stream public. */
    private final String publicShareUrl;

    /* Capture an image on demand. Returns the URL of an image captured from the live video stream.
    Requires that the camera is on and actively streaming. */
    private final String snapshotUrl;

    /* This object captures the last event that triggered a notification. */
    private final LastEvent lastEvent;

    public Camera(DeviceId deviceId, String softwareVersion, StructureId structureId, WhereId whereId,
                  String name, String nameLong, Boolean isOnline, Boolean isStreaming,
                  Boolean isAudioInputEnabled, DateTime lastIsOnlineChange, Boolean isVideoHistoryEnabled,
                  String webUrl, String appUrl, Boolean isPublicShareEnabled,
                  List<ActivityZone> activityZones, String publicShareUrl, String snapshotUrl,
                  LastEvent lastEvent) {
        this.deviceId = deviceId;
        this.softwareVersion = softwareVersion;
        this.structureId = structureId;
        this.whereId = whereId;
        this.name = name;
        this.nameLong = nameLong;
        this.isOnline = isOnline;
        this.isStreaming = isStreaming;
        this.isAudioInputEnabled = isAudioInputEnabled;
        this.lastIsOnlineChange = lastIsOnlineChange;
        this.isVideoHistoryEnabled = isVideoHistoryEnabled;
        this.webUrl = webUrl;
        this.appUrl = appUrl;
        this.isPublicShareEnabled = isPublicShareEnabled;
        this.activityZones = activityZones;
        this.publicShareUrl = publicShareUrl;
        this.snapshotUrl = snapshotUrl;
        this.lastEvent = lastEvent;
    }

    public DeviceId getDeviceId() {
        return deviceId;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public StructureId getStructureId() {
        return structureId;
    }

    public WhereId getWhereId() {
        return whereId;
    }

    public String getName() {
        return name;
    }

    public String getNameLong() {
        return nameLong;
    }

    public Boolean isOnline() {
        return isOnline;
    }

    public Boolean isStreaming() {
        return isStreaming;
    }

    public Boolean isAudioInputEnabled() {
        return isAudioInputEnabled;
    }

    public DateTime getLastIsOnlineChange() {
        return new DateTime(lastIsOnlineChange);
    }

    public Boolean isVideoHistoryEnabled() {
        return isVideoHistoryEnabled;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Boolean isPublicShareEnabled() {
        return isPublicShareEnabled;
    }

    public List<ActivityZone> getActivityZones() {
        return new ArrayList<>(activityZones);
    }

    public String getPublicShareUrl() {
        return publicShareUrl;
    }

    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public LastEvent getLastEvent() {
        return lastEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return isOnline == camera.isOnline &&
                isStreaming == camera.isStreaming &&
                isAudioInputEnabled == camera.isAudioInputEnabled &&
                isVideoHistoryEnabled == camera.isVideoHistoryEnabled &&
                isPublicShareEnabled == camera.isPublicShareEnabled &&
                Objects.equals(deviceId, camera.deviceId) &&
                Objects.equals(softwareVersion, camera.softwareVersion) &&
                Objects.equals(structureId, camera.structureId) &&
                Objects.equals(whereId, camera.whereId) &&
                Objects.equals(name, camera.name) &&
                Objects.equals(nameLong, camera.nameLong) &&
                Objects.equals(lastIsOnlineChange, camera.lastIsOnlineChange) &&
                Objects.equals(webUrl, camera.webUrl) &&
                Objects.equals(appUrl, camera.appUrl) &&
                Objects.equals(activityZones, camera.activityZones) &&
                Objects.equals(publicShareUrl, camera.publicShareUrl) &&
                Objects.equals(snapshotUrl, camera.snapshotUrl) &&
                Objects.equals(lastEvent, camera.lastEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, softwareVersion, structureId, whereId, name, nameLong, isOnline, isStreaming, isAudioInputEnabled, lastIsOnlineChange, isVideoHistoryEnabled, webUrl, appUrl, isPublicShareEnabled, activityZones, publicShareUrl, snapshotUrl, lastEvent);
    }
}
