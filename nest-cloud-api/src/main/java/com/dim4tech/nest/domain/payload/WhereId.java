package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WhereId {
    private final String id;

    public WhereId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhereId whereId = (WhereId) o;
        return Objects.equals(id, whereId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
