package com.dim4tech.nest.dto.payload.constants;

public enum AwayState {
    HOME("home"),
    AWAY("away"),
    AUTO_AWAY("auto-away"),
    UNKNOWN("unknown");

    private final String state;

    AwayState(String state) {
        this.state = state;
    }
}
