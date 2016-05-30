package com.dim4tech.nest.domain.payload;

import java.util.Objects;

public class ProductLocation {
    /* Unique identifier for the structure. */
    private final StructureId structureId;

    /* Where unique identifier. */
    private final WhereId whereId;

    public ProductLocation(StructureId structureId,
                           WhereId whereId) {
        this.structureId = structureId;
        this.whereId = whereId;
    }

    public StructureId getStructureId() {
        return structureId;
    }

    public WhereId getWhereId() {
        return whereId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLocation that = (ProductLocation) o;
        return Objects.equals(structureId, that.structureId) &&
                Objects.equals(whereId, that.whereId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structureId, whereId);
    }
}
