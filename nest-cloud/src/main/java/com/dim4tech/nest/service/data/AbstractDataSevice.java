package com.dim4tech.nest.service.data;

import com.dim4tech.nest.domain.error.ErrorMessage;
import com.dim4tech.nest.exception.NestIntegrationException;
import com.dim4tech.nest.service.deserializer.DeserializationService;

public abstract class AbstractDataSevice {
    protected NestIntegrationException createException(DeserializationService deserializationService, String message) {
        return new NestIntegrationException(deserializationService.deserialize(message, ErrorMessage.class));
    }
}
