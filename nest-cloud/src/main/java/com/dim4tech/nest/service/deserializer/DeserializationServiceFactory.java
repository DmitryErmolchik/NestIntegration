package com.dim4tech.nest.service.deserializer;

import java.util.Iterator;
import java.util.ServiceLoader;

public class DeserializationServiceFactory {
    public static DeserializationService getInstance() {
        final Iterator<DeserializationService> provides = ServiceLoader.load(DeserializationService.class).iterator();
        if (provides.hasNext()) {
            return provides.next();
        }
        return new DeserializationServiceImpl();
    }
}
