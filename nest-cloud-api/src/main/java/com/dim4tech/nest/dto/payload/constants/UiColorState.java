package com.dim4tech.nest.dto.payload.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UiColorState {
    GRAY("Offline"),
    GREEN("OK"),
    YELLOW("Warning"),
    RED("Emergency");

    private final String state;

    UiColorState(String state) {
        this.state = state;
    }

    @JsonValue
    public String getState() {
        return state;
    }
}
