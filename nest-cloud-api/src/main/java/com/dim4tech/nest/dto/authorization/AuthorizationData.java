package com.dim4tech.nest.dto.authorization;

public class AuthorizationData {
    private final String accessTocken;
    private final long expiresIn;

    public AuthorizationData(String accessTocken, long expiresIn) {
        this.accessTocken = accessTocken;
        this.expiresIn = expiresIn;
    }

    public String getAccessTocken() {
        return accessTocken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }
}
