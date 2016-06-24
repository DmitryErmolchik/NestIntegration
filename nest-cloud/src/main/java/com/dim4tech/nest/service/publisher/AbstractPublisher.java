package com.dim4tech.nest.service.publisher;

import com.dim4tech.nest.constant.Default;
import com.dim4tech.nest.dto.Response;
import com.dim4tech.nest.exception.NestIntegrationException;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import com.dim4tech.nest.service.serializer.SerializationService;
import com.dim4tech.nest.service.serializer.SerializationServiceImpl;
import com.dim4tech.nest.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPublisher<T> implements Publisher<T> {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final SerializationService serializationService = new SerializationServiceImpl();
    private final DeserializationService deserializationService  =new DeserializationServiceImpl();
    private final URL endpoint;
    private final String charset;
    private final String AUTH = "auth";

    protected AbstractPublisher(URL endpoint, String charset) {
        this.endpoint = endpoint;
        this.charset = charset;
    }

    protected AbstractPublisher(URL endpoint) {
        this(endpoint, Default.CHARSET);
    }

    @Override
    public abstract T publish(String accessToken, T object);

    protected T publishObject(String accessToken, T object, Class<T> returnObjectClass) {
        Map<String, String > params = new HashMap<>();
        params.put(AUTH, accessToken);
        try {
            URL dataUrl = new URL(endpoint + HttpHelper.encodeGetRequestParameters(params, charset));
            HttpURLConnection connection = (HttpURLConnection) dataUrl.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            String serializedObject = serializationService.serialize(object);
            LOG.debug("Sending object {}", serializedObject);
            HttpHelper.request(connection, serializedObject.getBytes(charset));
            Response response = HttpHelper.response(connection);
            if (response.getResponseCode() == 200) {
                return deserializationService.deserialize(response.getContent(), returnObjectClass);
            }
            else {
                throw NestIntegrationException.createException(deserializationService, response.getContent());
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

}
