package com.dim4tech.nest.service.authorization;

import com.dim4tech.nest.domain.authorization.AuthorizationData;
import com.dim4tech.nest.service.deserializer.DeserializationServiceImpl;
import com.sun.net.httpserver.HttpServer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthorizationServiceImplTest {
    private final String PRODUCT_ID = "abcdefgh-ijkl-mnop-qrst-uvwxyz012345";
    private final String PRODUCT_SECRET = "AbCdEfGhIjKlMnOpQrStUvWxY";
    private final String AUTHORIZATION_URL = "http://localhost";
    private final String AUTHORIZATION_CODE = "12345";
    private final int SERVER_PORT = 8000;
    private final String CHARSET = "UTF-8";
    private final String AUTHORIZATION_DATA = "{\"access_token\":\"c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX\"," +
            "\"expires_in\":315360000}";

    private HttpServer httpServer;

    private final AuthorizationServiceImpl authorizationService;

    public AuthorizationServiceImplTest() throws MalformedURLException {
        URL authorizationUrl = new URL(AUTHORIZATION_URL + ":" + SERVER_PORT);
        this.authorizationService = new AuthorizationServiceImpl(authorizationUrl, PRODUCT_ID, PRODUCT_SECRET);
        this.authorizationService.setDeserializationService(new DeserializationServiceImpl());
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAuthorizationCodeUrl() throws Exception {
        URL result = authorizationService.getAuthorizationCodeUrl("STATE");
        assertTrue(result.getQuery().equals("client_id=abcdefgh-ijkl-mnop-qrst-uvwxyz012345&state=STATE")
                || result.getQuery().equals("state=STATE&client_id=abcdefgh-ijkl-mnop-qrst-uvwxyz012345"));
    }

    @Test
    public void getAuthorizationData() throws Exception {
        try {
            startSimpleServer();
            AuthorizationData authorizationData = authorizationService.getAuthorizationData(AUTHORIZATION_CODE);
            assertEquals(buildExpectedAuthorizationData(), authorizationData);
        }
        finally {
            stopSimpleServer();
        }
    }

    private void startSimpleServer() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
            httpServer.createContext("/", httpExchange -> {
                String response = AUTHORIZATION_DATA;
                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(response.getBytes(CHARSET));
                outputStream.close();
            });
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopSimpleServer() {
        httpServer.stop(5);
    }

    private AuthorizationData buildExpectedAuthorizationData() {
        return new AuthorizationData("c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX",
                315360000);
    }
}