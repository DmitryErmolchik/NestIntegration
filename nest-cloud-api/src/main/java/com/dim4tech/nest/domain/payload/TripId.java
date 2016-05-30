package com.dim4tech.nest.domain.payload;

import java.util.Objects;

public class TripId {
    private final String id;

    public TripId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripId tripId = (TripId) o;
        return Objects.equals(id, tripId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
