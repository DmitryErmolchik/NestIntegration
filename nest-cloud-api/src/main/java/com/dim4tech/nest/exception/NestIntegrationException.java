package com.dim4tech.nest.exception;


import com.dim4tech.nest.domain.error.ErrorMessage;

public class NestIntegrationException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public NestIntegrationException() {
        errorMessage = null;
    }

    public NestIntegrationException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage() != null ? errorMessage.getMessage() : errorMessage.getErrorDescription());
        this.errorMessage = errorMessage;
    }
}
