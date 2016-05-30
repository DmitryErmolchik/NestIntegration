package com.dim4tech.nest.domain.payload;

import java.util.Objects;

public class ActivityZone {
    /* Activity zone id */
    private final ActivityZoneId id;
    /* Activity zone name */
    private final String name;

    public ActivityZone(ActivityZoneId id, String name) {
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
