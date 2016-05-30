package com.dim4tech.nest.domain.payload;

import java.util.Objects;

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
