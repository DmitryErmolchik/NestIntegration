package com.dim4tech.nest.constant;

import com.dim4tech.nest.exception.NestIntegrationException;

import java.net.MalformedURLException;
import java.net.URL;

public enum UrlConstant {
    AUTHORIZATION_URL("https://home.nest.com/login/oauth2"),
    ACCESS_TOKEN_URL("https://api.home.nest.com/oauth2/access_token");

    private URL url;

    UrlConstant(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new NestIntegrationException();
        }
    }

    public URL getUrl() {
        return url;
    }
}
