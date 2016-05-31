package com.dim4tech.nest.domain.payload.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AlarmState {
    OK("ok"),
    WARNING("warning"),
    EMERGENCY("emergency");

    private final String state;

    AlarmState(String state) {
        this.state = state;
    }

    @JsonValue
    public String getState() {
        return state;
    }
}

