package com.dim4tech.nest.domain.payload.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HvacState {
    HEATING("heating") /* Heating mode */,
    COOLING("cooling") /* Cooling mode */,
    OFF("off") /* System is off*/;

    private final String state;

    HvacState(String state) {
        this.state = state;
    }

    @JsonValue
    public String getState() {
        return state;
    }
}
