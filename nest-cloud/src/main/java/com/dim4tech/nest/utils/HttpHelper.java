package com.dim4tech.nest.utils;

import com.dim4tech.nest.exception.NestIntegrationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
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
}
