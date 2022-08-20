package me.test.takehome2022sunkyungcho.graphql;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public final class GraphqlClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GraphQLResponse post(GraphQLRequest request) {
        ResponseEntity<JsonNode> responseEntity = restTemplate.postForEntity(request.getUrl(), new HttpEntity<>(request.getRequestBody(), request.getHeaders()), JsonNode.class);
        JsonNode body = responseEntity.getBody();
        return new GraphQLResponse(body, objectMapper);
    }
}
