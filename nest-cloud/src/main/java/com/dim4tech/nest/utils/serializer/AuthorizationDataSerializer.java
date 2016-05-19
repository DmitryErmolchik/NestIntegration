package com.dim4tech.nest.utils.serializer;

import com.dim4tech.nest.dto.authorization.AuthorizationData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class AuthorizationDataSerializer extends JsonDeserializer<AuthorizationData> {
    @Override
    public AuthorizationData deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        String accessToken = jsonNode.get("access_token").textValue();
        long expiresIn = jsonNode.get("expires_in").longValue();
        return new AuthorizationData(accessToken, expiresIn);
    }
}
