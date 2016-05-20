package com.dim4tech.nest.dto.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorizationDataDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json = "{\"access_token\":\"c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX\"," +
                                                  "\"expires_in\":315360000}";

    @Test
    public void deserializationTest() throws Exception {
        AuthorizationData expected = new AuthorizationData("c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX",
                315360000);
        AuthorizationData result = objectMapper.readValue(json, AuthorizationData.class);
        assertEquals(expected.getAccessToken(), result.getAccessToken());
        assertEquals(expected.getExpiresIn(), result.getExpiresIn());
    }
}
