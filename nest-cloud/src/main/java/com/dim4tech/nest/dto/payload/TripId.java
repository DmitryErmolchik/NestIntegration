package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
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
