package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.Devices;
import com.dim4tech.nest.dto.Response;
import com.dim4tech.nest.exception.NestIntegrationException;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import com.dim4tech.nest.utils.Endpoints;

public class DevicesLoader extends AbstractLoader<Devices> {
    private final DeserializationService deserializationService = new DeserializationServiceImpl();

    public DevicesLoader(Endpoints endpoints, String charset) {
        super(endpoints, charset);
    }

    public DevicesLoader(Endpoints endpoints) {
        super(endpoints);
    }

    @Override
    public Devices load(String accessToken) {
        Response response = loadJsonData(accessToken);
        if (response.getResponseCode() == 200) {
            return deserializationService.deserialize(response.getContent(), Devices.class);
        }
        else {
            throw NestIntegrationException.createException(deserializationService, response.getContent());
        }
    }
}
