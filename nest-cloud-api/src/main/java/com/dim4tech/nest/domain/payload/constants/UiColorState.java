package com.dim4tech.nest.domain.payload.constants;

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

    public String getColor() {
        return color;
    }
}
