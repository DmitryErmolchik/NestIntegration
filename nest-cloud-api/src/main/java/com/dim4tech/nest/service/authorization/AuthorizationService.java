package com.dim4tech.nest.service.authorization;

import com.dim4tech.nest.dto.authorization.AuthorizationData;

import java.net.URL;

public interface AuthorizationService {
    URL getAuthorizationCodeUrl(String state);
    AuthorizationData getAuthorizationData(String authorizationCode);
}
