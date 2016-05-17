package com.dim4tech.nest.dto.payload.constants;

public enum AlarmState {
    OK("ok"),
    WARNING("warning"),
    EMERGENCY("emergency");

    private final String state;

    AlarmState(String state) {
        this.state = state;
    }
}
