package com.dim4tech.nest.service.authorization;

import com.dim4tech.nest.dto.authorization.AuthorizationData;
import com.dim4tech.nest.service.dtoservice.DtoServiceImpl;
import com.dim4tech.nest.utils.serializer.AuthorizationDataSerializer;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class AuthorizationServiceImplTest {
    /*private final String PRODUCT_ID = "abcdefgh-ijkl-mnop-qrst-uvwxyz012345";
    private final String PRODUCT_SECRET = "AbCdEfGhIjKlMnOpQrStUvWxY";
    private final String AUTHORIZATION_URL = "http://www.example.com";*/

    private final String PRODUCT_ID = "697545b0-df56-4985-8425-d75c28d10cc7";
    private final String PRODUCT_SECRET = "5VyV8U8XFV7kWSbsKhBSFnOpJ";
    private final String AUTHORIZATION_URL = "https://api.home.nest.com/oauth2/access_token";

    private final AuthorizationServiceImpl authorizationService;

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
        authorizationService.setDtoService(new DtoServiceImpl<AuthorizationData>(AuthorizationData.class, new AuthorizationDataSerializer()));
        authorizationService.getAuthorizationData("27M75223QM8Z4SNQ");
    }

}