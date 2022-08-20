package me.test.takehome2022sunkyungcho.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.test.takehome2022sunkyungcho.domain.BitcoinBlock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

class GraphqlClientTest {

    @Test
    @DisplayName("GraphqlClient을 통해 BitcoinBlock을 리턴 할 수 있어야 한다")
    void graphqqu_request_test() {
        GraphqlClient graphqlClient = new GraphqlClient(new RestTemplate(), new ObjectMapper());
        GraphQLRequest request = new BitqueryRequest("query MyQuery { " +
                "bitcoin { blocks(options: {desc: \"timestamp.time\"}, date: {is: \"2022-08-18\"}) { " +
                "count blockHash blockSize blockSizeBigInt blockStrippedSize blockVersion blockWeight difficulty height transactionCount timestamp { time } } " +
                "} }");
        GraphQLResponse response = graphqlClient.post(request);
        BitcoinBlock[] result = response.getList("/data/bitcoin/blocks", BitcoinBlock[].class);
        assertThat(result)
                .isNotNull()
                .hasSize(144);
    }

    @Test
    @DisplayName("잘못된 형태의 GraphQL 요청을 보내면 GraphQLClientException 발생한다")
    void graphqqu_request_exception_test() {
        GraphqlClient graphqlClient = new GraphqlClient(new RestTemplate(), new ObjectMapper());
        GraphQLRequest request = new BitqueryRequest("query MyQuery { " +
                "bitcoin { blocks(options: {desc: \"timestamp.time\"}, date: {is: \"2022-08-18\"}) { " +
                "count blockHash blockSize blockSizeBigInt blockStrip blockVersion blockWeight difficulty height transactionCount timestamp { time } } " +
                "} }");
        GraphQLResponse response = graphqlClient.post(request);

        Assertions.assertThrows(RuntimeException.class, () -> response.getList("/data/bitcoin/blocks", BitcoinBlock[].class));
    }
}