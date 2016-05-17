package com.dim4tech.nest.dto.payload;

import org.joda.time.DateTime;

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

    public LastEvent(boolean hasSound, boolean hasMotion, DateTime startTime, DateTime endTime,
                     DateTime urlsExpireTime, String webUrl, String appUrl, String imageUrl, String animatedImageUrl) {
        this.hasSound = hasSound;
        this.hasMotion = hasMotion;
        this.startTime = startTime;
        this.endTime = endTime;
        this.urlsExpireTime = urlsExpireTime;
        this.webUrl = webUrl;
        this.appUrl = appUrl;
        this.imageUrl = imageUrl;
        this.animatedImageUrl = animatedImageUrl;
    }

    public boolean isHasSound() {
        return hasSound;
    }

    public boolean isHasMotion() {
        return hasMotion;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public DateTime getUrlsExpireTime() {
        return urlsExpireTime;
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
}
