package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductLocation {
    private final static String STRUCTURE_ID = "structure_id";
    /* Unique identifier for the structure. */
    private final StructureId structureId;

    private final static String WHERE_ID = "where_id";
    /* Where unique identifier. */
    private final WhereId whereId;

    @JsonCreator
    public ProductLocation(@JsonProperty(STRUCTURE_ID) StructureId structureId,
                           @JsonProperty(WHERE_ID) WhereId whereId) {
        this.structureId = structureId;
        this.whereId = whereId;
    }

    public static ProductLocation createFromJson(Map<String, String> identificationData) {
        String structureId = null;
        String whereId = null;
        for (Map.Entry<String, String> entry : identificationData.entrySet()) {
            switch (entry.getKey()) {
                case STRUCTURE_ID:
                    structureId = entry.getValue();
                    break;
                case WHERE_ID:
                    whereId = entry.getValue();
                    break;
            }
        }
        return new ProductLocation(structureId != null ? new StructureId(structureId) : null,
                whereId != null ? new WhereId(whereId) : null);
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
