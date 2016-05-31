package com.dim4tech.nest.domain.payload;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LastEvent {
    /* Sound event - sound was detected. */
    private final boolean hasSound;

    /* Motion event - motion was detected. */
    private final boolean hasMotion;

    /* Event start time, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime startTime;

    /* Event end time, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime endTime;

    /* Timestamp that identifies when the last event URLs expire, in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime urlsExpireTime;

    /* Web URL (deep link) to the last sound or motion event at home.nest.com.
        Used to display the recorded event from the camera at that physical location (where).
        NOTE: If the event URL has expired or the device does not have an active subscription,
        then this value is not included in the payload. */
    private final String webUrl;

    /* Nest App URL (deep link) to the last sound or motion event.
        Used to display the recorded event from the camera at that physical location (where).
        NOTE: If the event URL has expired or the device does not have an active subscription,
        then this value is not included in the payload. */
    private final String appUrl;

    /* URL (link) to the image file captured at the start time of a sound or motion event. */
    private final String imageUrl;

    /* URL (link) to the gif file captured at the start time of a sound or motion event. */
    private final String animatedImageUrl;

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
