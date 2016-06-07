package com.dim4tech.nest.domain.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizationData that = (AuthorizationData) o;
        return Objects.equals(accessToken, that.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken);
    }
}
