package com.dim4tech.nest.domain.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMessage {
    private final static String ERROR = "error";
    private final String error;

    private final static String TYPE = "type";
    private final String type;

    private final static String MESSAGE = "message";
    private final String message;

    private final static String INSTANCE = "instance";
    private final String instance;

    private final static String DETAILS = "details";
    private final Map<String, String> details;

    private final static String ERROR_DESCRIPTION = "error_description";
    private final String errorDescription;

    private final static String INSTANCE_ID = "instance_id";
    private final String instanceId;

    @JsonCreator
    public ErrorMessage(@JsonProperty(ERROR) String error,
                        @JsonProperty(TYPE) String type,
                        @JsonProperty(MESSAGE) String message,
                        @JsonProperty(INSTANCE) String instance,
                        @JsonProperty(DETAILS) Map<String, String> details,
                        @JsonProperty(ERROR_DESCRIPTION) String errorDescription,
                        @JsonProperty(INSTANCE_ID) String instanceId) {
        this.error = error;
        this.type = type;
        this.message = message;
        this.instance = instance;
        this.details = details;
        this.errorDescription = errorDescription;
        this.instanceId = instanceId;
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

    public String getInstanceId() {
        return instanceId;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
