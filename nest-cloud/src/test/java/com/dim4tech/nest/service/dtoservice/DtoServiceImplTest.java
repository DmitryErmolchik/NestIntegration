package com.dim4tech.nest.service.dtoservice;

import com.dim4tech.nest.dto.authorization.AuthorizationDataDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DtoServiceImplTest {
    private DtoService dtoService = new DtoServiceImpl();

    private String authorizationDataJson = "{\"access_token\":\"c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX\",\"expires_in\":315360000}";

    @Test
    public void encodeAuthorizationData() throws Exception {
        AuthorizationDataDto expected = new AuthorizationDataDto("c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX", 315360000);
        AuthorizationDataDto result = dtoService.encode(authorizationDataJson, AuthorizationDataDto.class);
        assertEquals(expected.getAccessToken(), result.getAccessToken());
        assertEquals(expected.getExpiresIn(), result.getExpiresIn());
    }
}