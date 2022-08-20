package me.test.takehome2022sunkyungcho.graphql;

import org.springframework.http.HttpHeaders;

public final class BitqueryRequest implements GraphQLRequest {

    private static final String BITQUERY_URL = "https://graphql.bitquery.io";
    private final String query;

    public BitqueryRequest(String query) {
        this.query = query;
    }

    @Override
    public String getUrl() {
        return BITQUERY_URL;
    }

    @Override
    public GraphQLRequestBody getRequestBody() {
        return new GraphQLRequestBody(query);
    }

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY", "BQY9js2RZ4dI0asgFrUg0WfQphF2bvzs");
        return headers;
    }
}
