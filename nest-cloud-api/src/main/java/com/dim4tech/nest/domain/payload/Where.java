package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Where {
    private final static String WHERE_ID = "where_id";
    /* Where unique identifier. */
    private final WhereId whereId;

    private final static String NAME = "name";
    /* A standard list of rooms provided during device setup (Bedroom, Living Room, etc.).
        Users can optionally create a custom room name.
        You can create custom wheres (where_id and name).
        At this time, wheres cannot be edited or deleted after creation. */
    private final String name;

    @JsonCreator
    public Where(@JsonProperty(WHERE_ID) WhereId whereId,
                 @JsonProperty(NAME) String name) {
        this.whereId = whereId;
        this.name = name;
    }

    public WhereId getWhereId() {
        return whereId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Where where = (Where) o;
        return Objects.equals(whereId, where.whereId) &&
                Objects.equals(name, where.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whereId, name);
    }
}
