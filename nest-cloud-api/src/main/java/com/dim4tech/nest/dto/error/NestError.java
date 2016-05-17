package com.dim4tech.nest.dto.error;

import java.util.Map;

public class NestError {
    private String error;
    private String type;
    private String message;
    private String instance;
    private Map<String, String> details;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }
}
