package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.constant.Default;
import com.dim4tech.nest.dto.Response;
import com.dim4tech.nest.exception.NestIntegrationException;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import com.dim4tech.nest.utils.Endpoints;
import com.dim4tech.nest.utils.HttpHelper;
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
    protected final Endpoints endpoints;
    protected final String charset;
    private final String AUTH = "auth";

    public AbstractLoader(Endpoints endpoints, String charset) {
        this.endpoints = endpoints;
        this.charset = charset;
    }

    public AbstractLoader(Endpoints endpoints) {
        this(endpoints, Default.CHARSET);
    }

    protected Response loadJsonData(String accessToken) {
        Map<String, String > params = new HashMap<>();
        params.put(AUTH, accessToken);
        try {
            URL dataUrl = new URL(endpoints.getDevices() + HttpHelper.encodeGetRequestParameters(params, charset));
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
