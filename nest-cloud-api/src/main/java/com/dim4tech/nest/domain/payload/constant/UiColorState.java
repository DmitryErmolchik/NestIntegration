package com.dim4tech.nest.domain.payload.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UiColorState {
    GRAY("gray", "Offline"),
    GREEN("green", "OK"),
    YELLOW("yellow", "Warning"),
    RED("red", "Emergency");

    private final String color;
    private final String state;

    UiColorState(String color, String state) {
        this.color = color;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @JsonValue
    public String getColor() {
        return color;
    }
}