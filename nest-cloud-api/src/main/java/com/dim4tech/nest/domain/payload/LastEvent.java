package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
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

    @JsonCreator
    public LastEvent(@JsonProperty(HAS_SOUND) Boolean hasSound,
                     @JsonProperty(HAS_MOTION) Boolean hasMotion,
                     @JsonProperty(START_TIME) DateTime startTime,
                     @JsonProperty(END_TIME) DateTime endTime,
                     @JsonProperty(URLS_EXPIRE_TIME) DateTime urlsExpireTime,
                     @JsonProperty(WEB_URL) String webUrl,
                     @JsonProperty(APP_URL) String appUrl,
                     @JsonProperty(IMAGE_URL) String imageUrl,
                     @JsonProperty(ANIMATED_IMAGE_URL) String animatedImageUrl,
                     @JsonProperty(ACTIVITY_ZONE_IDS) List<ActivityZoneId> activityZoneIds) {
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
