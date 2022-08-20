package me.test.takehome2022sunkyungcho.graphql;

import lombok.Getter;

@Getter
final class GraphQLRequestBody {

    String query;

    public GraphQLRequestBody(String query) {
        this.query = query;
    }
}
