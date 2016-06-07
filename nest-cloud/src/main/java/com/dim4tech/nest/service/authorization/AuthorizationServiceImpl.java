package com.dim4tech.nest.service.authorization;

import com.dim4tech.nest.domain.authorization.AuthorizationData;
import com.dim4tech.nest.exception.NestIntegrationException;
import com.dim4tech.nest.service.deserializer.DeserializationService;
import com.dim4tech.nest.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationServiceImpl implements AuthorizationService {
    private final Logger LOG = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    private final URL authorizationUrl;
    private final String productId;
    private final String productSecret;
    private DeserializationService deserializationService;
    private final Map<String, String > params = new HashMap<>();

    private final static String CLIENT_ID = "client_id";
    private final static String CODE = "code";
    private final static String CLIENT_SECRET = "client_secret";
    private final static String GRANT_TYPE = "grant_type";
    private final static String GRANT_TYPE_VALUE = "authorization_code";

    private String charset = "UTF-8";

    public AuthorizationServiceImpl(URL authorizationUrl, String productId, String productSecret) {
        this.authorizationUrl = authorizationUrl;
        this.productId = productId;
        this.productSecret = productSecret;
        params.put("client_id", this.productId);
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setDeserializationService(DeserializationService deserializationService) {
        this.deserializationService = deserializationService;
    }

    @Override
    public URL getAuthorizationCodeUrl(String state) {
        try {
            params.put("state", state);
            return new URL(authorizationUrl, HttpHelper.encodeGetRequestParameters(params, charset));
        } catch (MalformedURLException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    @Override
    public AuthorizationData getAuthorizationData(String authorizationCode) {
        Map<String, String> params = new HashMap<>();
        params.put(CLIENT_ID, productId);
        params.put(CODE, authorizationCode);
        params.put(CLIENT_SECRET, productSecret);
        params.put(GRANT_TYPE, GRANT_TYPE_VALUE);
        try {
            HttpURLConnection connection = (HttpURLConnection) authorizationUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            HttpHelper.request(connection, HttpHelper.encodePostRequestParameters(params, charset));
            String response = HttpHelper.response(connection);
            AuthorizationData authorizationData = deserializationService.deserialize(response, AuthorizationData.class);
            return authorizationData;
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }
}
