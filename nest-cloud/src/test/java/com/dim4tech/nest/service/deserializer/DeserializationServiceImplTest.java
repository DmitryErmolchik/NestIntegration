package com.dim4tech.nest.service.deserializer;

import com.dim4tech.nest.domain.authorization.AuthorizationData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeserializationServiceImplTest {
    private DeserializationService deserializationService = new DeserializationServiceImpl();

    private String authorizationDataJson = "{\"access_token\":\"c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX\",\"expires_in\":315360000}";

    @Test
    public void encodeAuthorizationData() throws Exception {
        AuthorizationData expected = new AuthorizationData("c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX", 315360000);
        AuthorizationData result = deserializationService.deserialize(authorizationDataJson, AuthorizationData.class);
        assertEquals(expected.getAccessToken(), result.getAccessToken());
        assertEquals(expected.getExpiresIn(), result.getExpiresIn());
    }
}