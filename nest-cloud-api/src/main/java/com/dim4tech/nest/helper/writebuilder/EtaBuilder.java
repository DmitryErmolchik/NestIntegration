package com.dim4tech.nest.helper.writebuilder;

import com.dim4tech.nest.domain.payload.Eta;
import com.dim4tech.nest.domain.payload.TripId;
import org.joda.time.DateTime;

public class EtaBuilder {
    private TripId tripId;
    private DateTime estimatedArrivalWindowBegin;
    private DateTime estimatedArrivalWindowEnd;

    public EtaBuilder setTripId(TripId tripId) {
        this.tripId = tripId;
        return this;
    }

    public EtaBuilder setEstimatedArrivalWindowBegin(DateTime estimatedArrivalWindowBegin) {
        this.estimatedArrivalWindowBegin = estimatedArrivalWindowBegin;
        return this;
    }

    public EtaBuilder setEstimatedArrivalWindowEnd(DateTime estimatedArrivalWindowEnd) {
        this.estimatedArrivalWindowEnd = estimatedArrivalWindowEnd;
        return this;
    }

    public Eta build() {
        return new Eta(tripId, estimatedArrivalWindowBegin, estimatedArrivalWindowEnd);
    }
}
