package com.dim4tech.nest.service.serializer;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SerializationServiceFactory {
    public static SerializationService getInstance() {
        final Iterator<SerializationService> provides = ServiceLoader.load(SerializationService.class).iterator();
        if (provides.hasNext()) {
            return provides.next();
        }
        return new SerializationServiceImpl();
    }
}
