package com.dim4tech.nest.dto.payload;

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

        return id.equals(tripId.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
