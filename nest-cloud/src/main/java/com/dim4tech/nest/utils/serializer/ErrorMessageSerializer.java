package com.dim4tech.nest.utils.serializer;

import com.dim4tech.nest.dto.error.ErrorMessage;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ErrorMessageSerializer extends JsonDeserializer<ErrorMessage> {
    private final String ERROR = "error";
    private final String TYPE = "type";
    private final String MESSAGE = "message";
    private final String INSTANCE = "instance";
    private final String DETAILS = "details";

    @Override
    public ErrorMessage deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        String error = jsonNode.get(ERROR) != null ? jsonNode.get(ERROR).textValue() : null;
        String type = jsonNode.get(TYPE) != null ? jsonNode.get(TYPE).textValue() : null;
        String message = jsonNode.get(MESSAGE) != null ? jsonNode.get(MESSAGE).textValue() : null;
        String instance = jsonNode.get(INSTANCE) != null ? jsonNode.get(INSTANCE).textValue() : null;
        Map<String, String> details = new HashMap<>();
        if (jsonNode.get(DETAILS) != null) {
            jsonNode.get(DETAILS).fields().forEachRemaining(new Consumer<Map.Entry<String, JsonNode>>() {
                @Override
                public void accept(Map.Entry<String, JsonNode> jsonNodeEntry) {
                    details.put(jsonNodeEntry.getKey(), jsonNodeEntry.getValue().textValue());
                }
            });
        }
        return new ErrorMessage(error, type, message, instance, details);
    }
}
