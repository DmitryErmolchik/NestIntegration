package com.dim4tech.nest.dto.authorization;

public class AuthorizationData {
    private final String accessToken;
    private final long expiresIn;

    public AuthorizationData(String accessToken, long expiresIn) {
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
