package com.dim4tech.nest.dto.error;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {
    private final String error;
    private final String type;
    private final String message;
    private final String instance;
    private final Map<String, String> details;

    public ErrorMessage(String error, String type, String message, String instance, Map<String, String> details) {
        this.error = error;
        this.type = type;
        this.message = message;
        this.instance = instance;
        this.details = details;
    }

    public String getError() {
        return error;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getInstance() {
        return instance;
    }

    public Map<String, String> getDetails() {
        return new HashMap<>(details);
    }
}
