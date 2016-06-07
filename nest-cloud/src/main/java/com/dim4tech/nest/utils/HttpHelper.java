package com.dim4tech.nest.utils;

import com.dim4tech.nest.exception.NestIntegrationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;

public class HttpHelper {
    private final static Logger LOG = LoggerFactory.getLogger(HttpHelper.class);

    public static String encodeGetRequestParameters(Map<String, String> params, String charset) {
        return "?" + encodeParameters(params, charset);
    }

    public static byte[] encodePostRequestParameters(Map<String, String> params, String charset) {
        try {
            return encodeParameters(params, charset).getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            LOG.error(e.getMessage());
            throw new NestIntegrationException();
        }
    }

    private static String encodeParameters(Map<String, String> params, String charset) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                stringBuilder.append(URLEncoder.encode(entry.getKey(), charset))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), charset))
                        .append("&");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            LOG.error(e.getMessage());
            throw new NestIntegrationException();
        }
    }

    public static void request(HttpURLConnection connection, byte[] params) {
        try {
            connection.getOutputStream().write(params);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new NestIntegrationException();
        }
    }

    public static String response(HttpURLConnection connection) {
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
}
