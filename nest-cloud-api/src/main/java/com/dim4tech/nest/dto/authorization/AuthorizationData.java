package com.dim4tech.nest.dto.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationData {
    private final static String ACCESS_TOCKEN = "access_token";
    private final String accessToken;

    private final static String EXPIRES_IN = "expires_in";
    private final long expiresIn;

    @JsonCreator
    public AuthorizationData(@JsonProperty(ACCESS_TOCKEN) String accessToken,
                             @JsonProperty(EXPIRES_IN) long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }
}
