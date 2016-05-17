package com.dim4tech.nest.dto.payload;

import org.joda.time.DateTime;

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
    private final boolean isOnline;

    /* Camera status, either on and actively streaming video, or off. */
    private boolean isStreaming;

    /* Camera microphone status, either on and listening, or off. */
    private final boolean isAudioInputEnabled;

    /* Timestamp that identifies the last change to the online status,
        in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime lastIsOnlineChange;

    /* Nest Aware subscription status. */
    private final boolean isVideoHistoryEnabled;

    /* Web URL (deep link) to the device page at home.nest.com. Used to display the camera live feed
        at that physical location (where). */
    private final String webUrl;

    /* App URL (deep link) to the device screen in the Nest App.
        Used to display the camera live feed at that physical location (where). */
    private final String appUrl;

    /* This object captures the last event that triggered a notification. */
    private final LastEvent lastEvent;

    public Camera(DeviceId deviceId, String softwareVersion, StructureId structureId, WhereId whereId, String name,
                  String nameLong, boolean isOnline, boolean isStreaming, boolean isAudioInputEnabled,
                  DateTime lastIsOnlineChange, boolean isVideoHistoryEnabled, String webUrl, String appUrl,
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

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isStreaming() {
        return isStreaming;
    }

    public void setStreaming(boolean streaming) {
        isStreaming = streaming;
    }

    public boolean isAudioInputEnabled() {
        return isAudioInputEnabled;
    }

    public DateTime getLastIsOnlineChange() {
        return lastIsOnlineChange;
    }

    public boolean isVideoHistoryEnabled() {
        return isVideoHistoryEnabled;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public LastEvent getLastEvent() {
        return lastEvent;
    }
}
