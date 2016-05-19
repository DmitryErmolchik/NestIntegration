package com.dim4tech.nest.utils.serializer;

import com.dim4tech.nest.dto.authorization.AuthorizationData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class AuthorizationDataSerializer extends JsonDeserializer<AuthorizationData> {
    private final String ACCESS_TOKEN = "access_token";
    private final String EXPIRES_IN = "expires_in";

    @Override
    public AuthorizationData deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        String accessToken = jsonNode.get(ACCESS_TOKEN) != null ? jsonNode.get(ACCESS_TOKEN).textValue() : null;
        long expiresIn = jsonNode.get(EXPIRES_IN) != null ? jsonNode.get(EXPIRES_IN).longValue() : 0;
        return new AuthorizationData(accessToken, expiresIn);
    }
}
