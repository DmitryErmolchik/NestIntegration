package com.dim4tech.nest.service.dtoservice;

import com.dim4tech.nest.dto.authorization.AuthorizationData;
import com.dim4tech.nest.dto.error.ErrorMessage;
import com.dim4tech.nest.utils.serializer.AuthorizationDataSerializer;
import com.dim4tech.nest.utils.serializer.ErrorMessageSerializer;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DtoServiceImplTest {
    private String authorizationDataJson = "{\"access_token\":\"c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX\",\"expires_in\":315360000}";
    private DtoServiceImpl<AuthorizationData> authorizationDataDtoService = new DtoServiceImpl<>(AuthorizationData.class, new AuthorizationDataSerializer());

    private String errorMessageDataJson = "{\"error\": \"No write permission(s) for field(s): temperature_scale\"," +
            "  \"type\": \"https://developer.nest.com/documentation/cloud/error-messages#no-write-permission\"," +
            "  \"message\": \"No write permission(s) for field(s): temperature_scale\"," +
            "  \"instance\": \"ee3657bc-6df3-48ad-88ec-050f59e80b24\"," +
            "  \"details\": {" +
            "    \"fields\": \"temperature_scale\"" +
            "  }" +
            "}";
    private DtoServiceImpl<ErrorMessage> errorMessageDtoService = new DtoServiceImpl<>(ErrorMessage.class, new ErrorMessageSerializer());

    @Test
    public void encodeAuthorizationData() throws Exception {
        AuthorizationData expected = new AuthorizationData("c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX", 315360000);
        AuthorizationData result = authorizationDataDtoService.encode(authorizationDataJson);
        assertEquals(expected.getAccessToken(), result.getAccessToken());
        assertEquals(expected.getExpiresIn(), result.getExpiresIn());
    }

    @Test
    public void decodeAuthorizationData() throws Exception {

    }

    @Test
    public void encodeErrorMessage() throws Exception {
        Map<String, String> details = new HashMap<>();
        details.put("fields", "temperature_scale");
        ErrorMessage expected = new ErrorMessage("No write permission(s) for field(s): temperature_scale",
                "https://developer.nest.com/documentation/cloud/error-messages#no-write-permission",
                "No write permission(s) for field(s): temperature_scale",
                "ee3657bc-6df3-48ad-88ec-050f59e80b24",
                details);
        ErrorMessage result = errorMessageDtoService.encode(errorMessageDataJson);

        assertEquals(expected.getError(), result.getError());
        assertEquals(expected.getType(), result.getType());
        assertEquals(expected.getMessage(), result.getMessage());
        assertEquals(expected.getInstance(), result.getInstance());
        assertEquals(expected.getDetails(), result.getDetails());
    }

    @Test
    public void decodeErrorMessage() throws Exception {

    }
}