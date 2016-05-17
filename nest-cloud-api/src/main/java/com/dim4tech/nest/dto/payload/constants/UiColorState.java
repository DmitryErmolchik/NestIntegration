package com.dim4tech.nest.dto.payload.constants;

public enum UiColorState {
    GRAY("Offline"),
    GREEN("OK"),
    YELLOW("Warning"),
    RED("Emergency");

    private final String state;

    UiColorState(String state) {
        this.state = state;
    }
}
