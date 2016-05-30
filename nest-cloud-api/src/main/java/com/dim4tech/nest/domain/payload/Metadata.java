package com.dim4tech.nest.domain.payload;

import java.util.Objects;

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

    public Metadata(String accessToken,
                    int clientVersion) {
        this.accessToken = accessToken;
        this.clientVersion = clientVersion;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getClientVersion() {
        return clientVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metadata metadata = (Metadata) o;
        return clientVersion == metadata.clientVersion &&
                Objects.equals(accessToken, metadata.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, clientVersion);
    }
}
