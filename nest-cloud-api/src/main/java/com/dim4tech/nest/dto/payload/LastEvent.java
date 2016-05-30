package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LastEvent {
    private final static String HAS_SOUND = "has_sound";
    /* Sound event - sound was detected. */
    private final boolean hasSound;

    private final static String HAS_MOTION = "has_motion";
    /* Motion event - motion was detected. */
    private final boolean hasMotion;

    private final static String START_TIME = "start_time";
    /* Event start time, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime startTime;

    private final static String END_TIME = "end_time";
    /* Event end time, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime endTime;

    private final static String URLS_EXPIRE_TIME = "urls_expire_time";
    /* Timestamp that identifies when the last event URLs expire, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime urlsExpireTime;

    private final static String WEB_URL = "web_url";
    /* Web URL (deep link) to the last sound or motion event at home.nest.com.
        Used to display the recorded event from the camera at that physical location (where).
        NOTE: If the event URL has expired or the device does not have an active subscription,
        then this value is not included in the payload. */
    private final String webUrl;

    private final static String APP_URL = "app_url";
    /* Nest App URL (deep link) to the last sound or motion event.
        Used to display the recorded event from the camera at that physical location (where).
        NOTE: If the event URL has expired or the device does not have an active subscription,
        then this value is not included in the payload. */
    private final String appUrl;

    private final static String IMAGE_URL = "image_url";
    /* URL (link) to the image file captured at the start time of a sound or motion event. */
    private final String imageUrl;

    private final static String ANIMATED_IMAGE_URL = "animated_image_url";
    /* URL (link) to the gif file captured at the start time of a sound or motion event. */
    private final String animatedImageUrl;

    private final static String ACTIVITY_ZONE_IDS = "activity_zone_ids";
    /* Identifiers for Activity Zones that detected a motion event. Used with activity_zones and has_motion. */
    private final List<ActivityZoneId> activityZoneIds;

    public LastEvent(
            Boolean hasSound,
            Boolean hasMotion,
            DateTime startTime,
            DateTime endTime,
            DateTime urlsExpireTime,
            String webUrl,
            String appUrl,
            String imageUrl,
            String animatedImageUrl,
            List<ActivityZoneId> activityZoneIds) {
        this.hasSound = hasSound;
        this.hasMotion = hasMotion;
        this.startTime = startTime;
        this.endTime = endTime;
        this.urlsExpireTime = urlsExpireTime;
        this.webUrl = webUrl;
        this.appUrl = appUrl;
        this.imageUrl = imageUrl;
        this.animatedImageUrl = animatedImageUrl;
        this.activityZoneIds = activityZoneIds;
    }

    @JsonCreator
    public static LastEvent createFromJson(Map<String, Object> props) {
        Boolean hasSound = null;
        Boolean hasMotion = null;
        DateTime startTime = null;
        DateTime endTime = null;
        DateTime urlsExpireTime = null;
        String webUrl = null;
        String appUrl = null;
        String imageUrl = null;
        String animatedImageUrl = null;
        List<ActivityZoneId> activityZoneIds = new ArrayList<>();

        for (Map.Entry<String, Object> entry : props.entrySet()) {
            switch (entry.getKey()) {
                case HAS_SOUND:
                    hasSound = entry.getValue();
                    break;
                case HAS_MOTION:
                    hasMotion = entry.getValue();
                    break;
                case START_TIME:
                    startTime = entry.getValue();
                    break;
                case END_TIME:
                    endTime = entry.getValue();
                    break;
                case URLS_EXPIRE_TIME:
                    urlsExpireTime = entry.getValue();
                    break;
                case WEB_URL:
                    webUrl = entry.getValue();
                    break;
                case APP_URL:
                    appUrl = entry.getValue();
                    break;
                case IMAGE_URL:
                    imageUrl = entry.getValue();
                    break;
                case ANIMATED_IMAGE_URL:
                    animatedImageUrl = entry.getValue();
                    break;
                case ACTIVITY_ZONE_IDS:
                    activityZoneIds = entry.getValue();
                    break;
            }
        }
        activityZoneIds = activityZoneIds.size() == 0 ? null : activityZoneIds;
        return new LastEvent(hasSound, hasMotion, startTime, endTime, urlsExpireTime, webUrl, appUrl,
                imageUrl, animatedImageUrl, activityZoneIds);
    }

    public boolean isHasSound() {
        return hasSound;
    }

    public boolean isHasMotion() {
        return hasMotion;
    }

    public DateTime getStartTime() {
        return new DateTime(startTime);
    }

    public DateTime getEndTime() {
        return new DateTime(endTime);
    }

    public DateTime getUrlsExpireTime() {
        return new DateTime(urlsExpireTime);
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAnimatedImageUrl() {
        return animatedImageUrl;
    }

    public List<ActivityZoneId> getActivityZoneIds() {
        return new ArrayList<>(activityZoneIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastEvent lastEvent = (LastEvent) o;
        return hasSound == lastEvent.hasSound &&
                hasMotion == lastEvent.hasMotion &&
                Objects.equals(startTime, lastEvent.startTime) &&
                Objects.equals(endTime, lastEvent.endTime) &&
                Objects.equals(urlsExpireTime, lastEvent.urlsExpireTime) &&
                Objects.equals(webUrl, lastEvent.webUrl) &&
                Objects.equals(appUrl, lastEvent.appUrl) &&
                Objects.equals(imageUrl, lastEvent.imageUrl) &&
                Objects.equals(animatedImageUrl, lastEvent.animatedImageUrl) &&
                Objects.equals(activityZoneIds, lastEvent.activityZoneIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasSound, hasMotion, startTime, endTime, urlsExpireTime, webUrl, appUrl, imageUrl, animatedImageUrl, activityZoneIds);
    }
}
