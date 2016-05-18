package com.dim4tech.nest.service.authorization;

import java.net.URL;

public interface AuthorizationService {
    URL getAuthorizationCodeUrl(String state);
    String getAccessToken(String authorizationCode);
}
