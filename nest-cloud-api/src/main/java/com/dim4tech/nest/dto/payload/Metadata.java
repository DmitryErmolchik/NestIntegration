package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {
    /*
        Part of user authorization, your client will use an access token to make API calls to the Nest service.
        This access token serves as proof that a user has authorized your client to make calls on their behalf.
     */
    private final static String ACCESS_TOKEN = "access_token";
    private final String accessToken;

    /*
        Client version is the last user-authorized version of a client, and is associated with an access_token.
     */
    private final static String CLIENT_VERSION = "client_version";
    private final int clientVersion;

    @JsonCreator
    public Metadata(@JsonProperty(ACCESS_TOKEN) String accessToken,
                    @JsonProperty(CLIENT_VERSION) int clientVersion) {
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
