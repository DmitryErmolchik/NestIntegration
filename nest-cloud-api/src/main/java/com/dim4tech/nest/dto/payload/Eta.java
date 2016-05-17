package com.dim4tech.nest.dto.payload;

import org.joda.time.DateTime;

public class Eta {
    /* Unique identifier for this ETA instance */
    private TripId tripId;

    /* Beginning time of the estimated arrival window, in ISO 8601 (http://en.wikipedia.org/wiki/ISO_8601) format */
    private DateTime estimatedArrivalWindowBegin;

    /* End time of the estimated arrival window, in ISO 8601 (http://en.wikipedia.org/wiki/ISO_8601) format */
    private DateTime estimatedArrivalWindowEnd;

    public Eta(TripId tripId, DateTime estimatedArrivalWindowBegin, DateTime estimatedArrivalWindowEnd) {
        this.tripId = tripId;
        this.estimatedArrivalWindowBegin = estimatedArrivalWindowBegin;
        this.estimatedArrivalWindowEnd = estimatedArrivalWindowEnd;
    }

    public TripId getTripId() {
        return tripId;
    }

    public void setTripId(TripId tripId) {
        this.tripId = tripId;
    }

    public DateTime getEstimatedArrivalWindowBegin() {
        return estimatedArrivalWindowBegin;
    }

    public void setEstimatedArrivalWindowBegin(DateTime estimatedArrivalWindowBegin) {
        this.estimatedArrivalWindowBegin = estimatedArrivalWindowBegin;
    }

    public DateTime getEstimatedArrivalWindowEnd() {
        return estimatedArrivalWindowEnd;
    }

    public void setEstimatedArrivalWindowEnd(DateTime estimatedArrivalWindowEnd) {
        this.estimatedArrivalWindowEnd = estimatedArrivalWindowEnd;
    }
}
