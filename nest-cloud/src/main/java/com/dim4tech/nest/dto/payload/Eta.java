package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Eta {
    private final static String TRIP_ID = "trip_id";
    /* Unique identifier for this ETA instance */
    private final TripId tripId;

    private final static String ESTIMATED_ARRIVAL_WINDOWS_BEGIN = "estimated_arrival_window_begin";
    /* Beginning time of the estimated arrival window, in ISO 8601 (http://en.wikipedia.org/wiki/ISO_8601) format */
    private final DateTime estimatedArrivalWindowBegin;

    private final static String ESTIMATE_ARRIVAL_WINDOWS_END = "estimated_arrival_window_end";
    /* End time of the estimated arrival window, in ISO 8601 (http://en.wikipedia.org/wiki/ISO_8601) format */
    private final DateTime estimatedArrivalWindowEnd;

    @JsonCreator
    public Eta(
            @JsonProperty(TRIP_ID) TripId tripId,
            @JsonProperty(ESTIMATED_ARRIVAL_WINDOWS_BEGIN) DateTime estimatedArrivalWindowBegin,
            @JsonProperty(ESTIMATE_ARRIVAL_WINDOWS_END) DateTime estimatedArrivalWindowEnd) {
        this.tripId = tripId;
        this.estimatedArrivalWindowBegin = estimatedArrivalWindowBegin;
        this.estimatedArrivalWindowEnd = estimatedArrivalWindowEnd;
    }

    public TripId getTripId() {
        return tripId;
    }

    public DateTime getEstimatedArrivalWindowBegin() {
        return new DateTime(estimatedArrivalWindowBegin);
    }

    public DateTime getEstimatedArrivalWindowEnd() {
        return new DateTime(estimatedArrivalWindowEnd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eta eta = (Eta) o;
        return Objects.equals(tripId, eta.tripId) &&
                Objects.equals(estimatedArrivalWindowBegin, eta.estimatedArrivalWindowBegin) &&
                Objects.equals(estimatedArrivalWindowEnd, eta.estimatedArrivalWindowEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, estimatedArrivalWindowBegin, estimatedArrivalWindowEnd);
    }
}
