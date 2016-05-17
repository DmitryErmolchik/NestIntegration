package com.dim4tech.nest.dto.payload;

public class Where {
    /* Where unique identifier. */
    private final WhereId whereId;

    /* A standard list of rooms provided during device setup (Bedroom, Living Room, etc.).
        Users can optionally create a custom room name.
        You can create custom wheres (where_id and name).
        At this time, wheres cannot be edited or deleted after creation. */
    private String name;

    public Where(WhereId whereId, String name) {
        this.whereId = whereId;
        this.name = name;
    }

    public WhereId getWhereId() {
        return whereId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
