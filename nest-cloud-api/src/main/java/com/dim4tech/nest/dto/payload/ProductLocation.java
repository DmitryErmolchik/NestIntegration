package com.dim4tech.nest.dto.payload;

public class ProductLocation {
    /* Unique identifier for the structure. */
    private final StructureId structureId;
    /* Where unique identifier. */
    private final WhereId whereId;

    public ProductLocation(StructureId structureId, WhereId whereId) {
        this.structureId = structureId;
        this.whereId = whereId;
    }

    public StructureId getStructureId() {
        return structureId;
    }

    public WhereId getWhereId() {
        return whereId;
    }
}
