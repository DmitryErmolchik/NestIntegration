package com.dim4tech.nest.dto.payload.constants;

public enum HvacMode {
    HEAT("heat") /* Heating mode */,
    COOL("cool") /* Cooling mode */,
    HEATCOOL("heat-cool") /* Heating and cooling (Heat • Cool) */,
    OFF("off") /* System is off*/;

    private final String mode;

    HvacMode(String mode) {
        this.mode = mode;
    }
}
