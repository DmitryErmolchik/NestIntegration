package com.dim4tech.nest.service.authorization;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class AuthorizationServiceImplTest {
    private final String PRODUCT_ID = "abcdefgh-ijkl-mnop-qrst-uvwxyz012345";
    private final String PRODUCT_SECRET = "AbCdEfGhIjKlMnOpQrStUvWxY";
    private final String AUTHORIZATION_URL = "http://www.example.com";

    private final AuthorizationService authorizationService;

    public AuthorizationServiceImplTest() throws MalformedURLException {
        URL authorizationUrl = new URL(AUTHORIZATION_URL);
        this.authorizationService = new AuthorizationServiceImpl(authorizationUrl, PRODUCT_ID, PRODUCT_SECRET);
    }

    @Before
    public void sutUp() throws Exception {
    }

    @Test
    public void getAuthorizationCodeUrl() throws Exception {
        URL result = authorizationService.getAuthorizationCodeUrl("STATE");
        assertTrue(result.getQuery().equals("client_id=abcdefgh-ijkl-mnop-qrst-uvwxyz012345&state=STATE")
            || result.getQuery().equals("state=STATE&client_id=abcdefgh-ijkl-mnop-qrst-uvwxyz012345"));
    }

    @Test
    public void getAccessToken() throws Exception {
        //TODO: test from another connection
        //authorizationService.getAccessToken("RB8NSAWHQYFNL7XY");
    }

}