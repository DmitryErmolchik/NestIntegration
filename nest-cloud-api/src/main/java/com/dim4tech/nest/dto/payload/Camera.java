package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Camera {
    private final static String DEVICE_ID = "device_id";
    /* Camera unique identifier */
    private final DeviceId deviceId;

    private final static String SOFTWARE_VERSION = "software_version";
    /* Software version */
    private final String softwareVersion;

    private final static String STRUCTURE_ID = "structure_id";
    /* Unique structure identifier */
    private final StructureId structureId;

    private final static String WHERE_ID = "where_id";
    /* Where unique identifier. */
    private final WhereId whereId;

    private final static String NAME = "name";
    /* Display name of the device */
    private final String name;

    private final static String NAME_LONG = "name_long";
    /* Long display name of the device */
    private final String nameLong;

    private final static String IS_ONLINE = "is_online";
    /* Device connection status with the Nest Service */
    private final Boolean isOnline;

    private final static String IS_STREAMING = "is_streaming";
    /* Camera status, either on and actively streaming video, or off. */
    private final Boolean isStreaming;

    private final static String IS_AUDIO_INPUT_ENABLED = "is_audio_input_enabled";
    /* Camera microphone status, either on and listening, or off. */
    private final Boolean isAudioInputEnabled;

    private final static String LAST_IS_ONLINE_CHANGE = "last_is_online_change";
    /* Timestamp that identifies the last change to the online status,
        in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime lastIsOnlineChange;

    private final static String IS_LAST_VIDEO_HISTORY_ENABLED = "is_video_history_enabled";
    /* Nest Aware subscription status. */
    private final Boolean isVideoHistoryEnabled;

    private final static String WEB_URL = "web_url";
    /* Web URL (deep link) to the device page at home.nest.com. Used to display the camera live feed
        at that physical location (where). */
    private final String webUrl;

    private final static String APP_URL = "app_url";
    /* App URL (deep link) to the device screen in the Nest App.
        Used to display the camera live feed at that physical location (where). */
    private final String appUrl;

    private final static String IS_PUBLIC_SHARE_ENABLED = "is_public_share_enabled";
    /* Users can choose to share their video and make it viewable by anyone.
        When public share is enabled, you can read public_share_url. */
    private final Boolean isPublicShareEnabled;

    private final static String ACTIVITY_ZONES = "activity_zones";
    /* Activity Zones are used to monitor motion events within user-defined areas of the video stream. */
    private final List<ActivityZone> activityZones;

    private final static String PUBLIC_SHARE_URL = "public_share_url";
    /* You can access this URL when a user makes their video stream public. */
    private final String publicShareUrl;

    private final static String SNAPSHOT_URL = "snapshot_url";
    /* Capture an image on demand. Returns the URL of an image captured from the live video stream.
    Requires that the camera is on and actively streaming. */
    private final String snapshotUrl;

    private final static String LAST_EVENT = "last_event";
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

    @JsonCreator
    public static Camera createFromJson(Map<String, Object> props) {
        DeviceId deviceId = null;
        String softwareVersion = null;
        StructureId structureId = null;
        WhereId whereId = null;
        String name = null;
        String nameLong = null;
        Boolean isOnline = null;
        Boolean isStreaming = null;
        Boolean isAudioInputEnabled = null;
        DateTime lastIsOnlineChange = null;
        Boolean isVideoHistoryEnabled = null;
        String webUrl = null;
        String appUrl = null;
        Boolean isPublicShareEnabled = null;
        List<ActivityZone> activityZones = new ArrayList<>();
        String publicShareUrl = null;
        String snapshotUrl = null;
        LastEvent lastEvent = null;

        for (Map.Entry<String, Object> entry : props.entrySet()) {
            switch (entry.getKey()) {
                case DEVICE_ID:
                    deviceId = new DeviceId((String) entry.getValue());
                    break;
                case SOFTWARE_VERSION:
                    softwareVersion = (String) entry.getValue();
                    break;
                case STRUCTURE_ID:
                    structureId = new StructureId((String) entry.getValue());
                    break;
                case WHERE_ID:
                    whereId = new WhereId((String) entry.getValue());
                    break;
                case NAME:
                    name = (String) entry.getValue();
                    break;
                case NAME_LONG:
                    nameLong = (String) entry.getValue();
                    break;
                case IS_ONLINE:
                    isOnline = (Boolean) entry.getValue();
                    break;
                case IS_STREAMING:
                    isStreaming = (Boolean) entry.getValue();
                    break;
                case IS_AUDIO_INPUT_ENABLED:
                    isAudioInputEnabled = (Boolean) entry.getValue();
                    break;
                case LAST_IS_ONLINE_CHANGE:
                    lastIsOnlineChange = DateTime.parse((String) entry.getValue());
                    break;
                case IS_LAST_VIDEO_HISTORY_ENABLED:
                    isVideoHistoryEnabled = (Boolean) entry.getValue();
                    break;
                case WEB_URL:
                    webUrl = (String) entry.getValue();
                    break;
                case APP_URL:
                    appUrl = (String) entry.getValue();
                    break;
                case IS_PUBLIC_SHARE_ENABLED:
                    isPublicShareEnabled = (Boolean) entry.getValue();
                    break;
                case ACTIVITY_ZONES:
                    for (Object activityZoneObject : ((List <Object>) entry.getValue())) {
                        activityZones.add(ActivityZone.createFromJson((Map<String, Object>) activityZoneObject));
                    }
                    break;
                case PUBLIC_SHARE_URL:
                    publicShareUrl = (String) entry.getValue();
                    break;
                case SNAPSHOT_URL:
                    snapshotUrl = (String) entry.getValue();
                    break;
                case LAST_EVENT:
                    lastEvent = null; //entry.getValue();
                    break;
            }
        }

        activityZones = activityZones.size() == 0 ? null : activityZones;

        return new Camera(deviceId, softwareVersion, structureId, whereId, name, nameLong, isOnline,
                isStreaming, isAudioInputEnabled, lastIsOnlineChange, isVideoHistoryEnabled, webUrl,
                appUrl, isPublicShareEnabled, activityZones, publicShareUrl, snapshotUrl, lastEvent);
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
