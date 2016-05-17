package com.dim4tech.nest.dto.payload;

public class Metadata {
    /*
        Part of user authorization, your client will use an access token to make API calls to the Nest service.
        This access token serves as proof that a user has authorized your client to make calls on their behalf.
     */
    private final String accessToken;

    /*
        Client version is the last user-authorized version of a client, and is associated with an access_token.
     */
    private final int clientVersion;

    public Metadata(String accessToken, int clientVersion) {
        this.accessToken = accessToken;
        this.clientVersion = clientVersion;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getClientVersion() {
        return clientVersion;
    }
}
