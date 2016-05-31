package com.dim4tech.nest.domain.payload.constants;

public enum AlarmState {
    OK("ok"),
    WARNING("warning"),
    EMERGENCY("emergency");

    private final String state;

    AlarmState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
