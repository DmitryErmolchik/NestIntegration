package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.Objects;

public class ActivityZone {
    private final static String ID = "id";
    /* Activity zone id */
    private final ActivityZoneId id;

    private final static String NAME = "name";
    /* Activity zone name */
    private final String name;

    public ActivityZone(ActivityZoneId id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonCreator
    public static ActivityZone createFromJson(Map<String, Object> props) {
        ActivityZoneId id = null;
        String name = null;
        for (Map.Entry<String, Object> entry : props.entrySet()) {
            switch (entry.getKey()) {
                case ID:
                    id = new ActivityZoneId((String) entry.getValue());
                    break;
                case NAME:
                    name  = (String) entry.getValue();
                    break;
            }
        }
        return new ActivityZone(id, name);
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
