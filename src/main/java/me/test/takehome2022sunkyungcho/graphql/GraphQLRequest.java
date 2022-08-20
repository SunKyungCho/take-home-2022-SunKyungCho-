package me.test.takehome2022sunkyungcho.graphql;

import org.springframework.http.HttpHeaders;

public interface GraphQLRequest {

    String getUrl();
    GraphQLRequestBody getRequestBody();

    HttpHeaders getHeaders();
}
