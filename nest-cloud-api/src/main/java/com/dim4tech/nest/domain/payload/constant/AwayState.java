package com.dim4tech.nest.domain.payload.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AwayState {
    HOME("home"),
    AWAY("away"),
    AUTO_AWAY("auto-away"),
    UNKNOWN("unknown");

    private final String state;

    AwayState(String state) {
        this.state = state;
    }

    @JsonValue
    public String getState() {
        return state;
    }
}