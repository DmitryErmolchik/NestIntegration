package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityZone {
    private final static String ID = "id";
    /* Activity zone id */
    @JsonProperty(ID)
    private final ActivityZoneId id;

    private final static String NAME = "name";
    /* Activity zone name */
    @JsonProperty(NAME)
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
