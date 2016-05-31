package com.dim4tech.nest.domain.payload.constant;

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
