package com.dim4tech.nest.dto.payload;

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

        return id.equals(whereId.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
