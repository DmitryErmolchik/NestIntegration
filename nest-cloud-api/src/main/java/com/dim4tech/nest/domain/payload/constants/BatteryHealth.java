package com.dim4tech.nest.domain.payload.constants;

public enum BatteryHealth {
    OK("ok"),
    REPLACE("replace");

    private final String health;

    BatteryHealth(String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }
}
