package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.constant.Default;
import com.dim4tech.nest.dto.Response;
import com.dim4tech.nest.exception.NestIntegrationException;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import com.dim4tech.nest.utils.HttpHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLoader<T> implements Loader<T> {
    private final Logger LOG = LoggerFactory.getLogger(AbstractLoader.class);
    private final DeserializationService deserializationService = new DeserializationServiceImpl();
    private final URL endpoint;
    private final String charset;
    private final String AUTH = "auth";

    protected AbstractLoader(URL endpoint, String charset) {
        this.endpoint = endpoint;
        this.charset = charset;
    }

    protected AbstractLoader(URL endpoint) {
        this(endpoint, Default.CHARSET);
    }

    protected T loadJsonData(String accessToken, Class<T> clazz) {
        Response response = loadResponse(accessToken);
        if (response.getResponseCode() == 200) {
            return deserializationService.deserialize(response.getContent(), clazz);
        }
        else {
            throw NestIntegrationException.createException(deserializationService, response.getContent());
        }
    }

    protected T loadJsonData(String accessToken, TypeReference valueTypeRef) {
        Response response = loadResponse(accessToken);
        if (response.getResponseCode() == 200) {
            return deserializationService.deserialize(response.getContent(), valueTypeRef);
        }
        else {
            throw NestIntegrationException.createException(deserializationService, response.getContent());
        }
    }

    private Response loadResponse(String accessToken) {
        Map<String, String > params = new HashMap<>();
        params.put(AUTH, accessToken);
        try {
            URL dataUrl = new URL(endpoint + HttpHelper.encodeGetRequestParameters(params, charset));
            HttpURLConnection connection = (HttpURLConnection) dataUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            return HttpHelper.response(connection);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    @Override
    public abstract T load(String accessToken);
}
