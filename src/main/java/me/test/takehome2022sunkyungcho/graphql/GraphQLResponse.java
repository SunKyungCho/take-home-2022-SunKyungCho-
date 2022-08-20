package me.test.takehome2022sunkyungcho.graphql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import me.test.takehome2022sunkyungcho.exception.GraphQLClientException;


@Getter
public final class GraphQLResponse {

    private final ObjectMapper objectMapper;
    private final JsonNode data;

    GraphQLResponse(JsonNode response, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.data = response;
    }

    public <T> T getList(String path, Class<T> type) {
        try {
            JsonNode jsonNode = data.at(path);
            return objectMapper.readValue(jsonNode.toString(), type);
        } catch (JsonProcessingException e) {
            throw new GraphQLClientException("Cannot read response", e);
        }
    }
}
