package com.dim4tech.nest.dto.payload.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BatteryHealth {
    OK("ok"),
    REPLACE("replace");

    private final String health;

    BatteryHealth(String health) {
        this.health = health;
    }

    @JsonValue
    public String getHealth() {
        return health;
    }
}
