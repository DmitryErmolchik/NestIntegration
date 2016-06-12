package com.dim4tech.nest.exception;


import com.dim4tech.nest.domain.error.ErrorMessage;
import com.dim4tech.nest.service.deserializer.DeserializationService;

public class NestIntegrationException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public NestIntegrationException() {
        errorMessage = null;
    }

    public NestIntegrationException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage() != null ? errorMessage.getMessage() : errorMessage.getErrorDescription());
        this.errorMessage = errorMessage;
    }

    public static NestIntegrationException createException(DeserializationService deserializationService, String message) {
        return new NestIntegrationException(deserializationService.deserialize(message, ErrorMessage.class));
    }

}
