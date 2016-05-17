package com.dim4tech.nest.dto.payload.constants;

public enum HvacState {
    HEATING("heating") /* Heating mode */,
    COOLING("cooling") /* Cooling mode */,
    OFF("off") /* System is off*/;

    private final String state;

    HvacState(String state) {
        this.state = state;
    }
}
