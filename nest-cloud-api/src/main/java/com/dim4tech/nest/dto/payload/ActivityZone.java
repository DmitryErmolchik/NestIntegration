package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ActivityZone {
    private final static String ID = "id";
    /* Activity zone id */
    private final ActivityZoneId id;

    private final static String NAME = "name";
    /* Activity zone name */
    private final String name;

    @JsonCreator
    public ActivityZone(
            @JsonProperty(ID) ActivityZoneId id,
            @JsonProperty(NAME) String name) {
        this.id = id;
        this.name = name;
    }

    public ActivityZoneId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityZone that = (ActivityZone) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
