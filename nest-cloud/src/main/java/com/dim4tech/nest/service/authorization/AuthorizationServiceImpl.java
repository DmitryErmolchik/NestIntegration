package com.dim4tech.nest.service.authorization;

import com.dim4tech.nest.exception.NestIntegrationException;
import com.dim4tech.nest.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationServiceImpl implements AuthorizationService {
    private final Logger LOG = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    private final URL authorizationUrl;
    private final String productId;
    private final String productSecret;
    private final Map<String, String > params = new HashMap<>();


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

    public URL getAuthorizationCodeUrl(String state) {
        try {
            params.put("state", state);
            return new URL(authorizationUrl, HttpHelper.encodeGetRequestParameters(params, charset));
        } catch (MalformedURLException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    public String getAccessToken(String authorizationCode) {
        try {
            HttpURLConnection connection = (HttpsURLConnection) authorizationUrl.openConnection();
            doPost(connection, getPostParams(authorizationCode));
            return doGet(connection);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    private void doPost(HttpURLConnection connection, byte[] params) {
        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.getOutputStream().write(params);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    private String doGet(HttpURLConnection connection) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            bufferedReader.close();
            return result.toString();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    private byte[] getPostParams(String authorizationCode) {
        try {
            String requestUrl = null;
            requestUrl = String.format("client_id=%s" +
                                       "&code=%s" +
                                       "&client_secret=%s" +
                                       "&grant_type=authorization_code",
                    URLEncoder.encode(productId, charset),
                    URLEncoder.encode(authorizationCode, charset),
                    URLEncoder.encode(productSecret, charset));
            return requestUrl.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }
}
