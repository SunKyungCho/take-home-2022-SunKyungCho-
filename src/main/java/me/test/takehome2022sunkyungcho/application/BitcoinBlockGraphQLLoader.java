package me.test.takehome2022sunkyungcho.application;

import lombok.RequiredArgsConstructor;
import me.test.takehome2022sunkyungcho.domain.BitcoinBlock;
import me.test.takehome2022sunkyungcho.graphql.BitqueryRequest;
import me.test.takehome2022sunkyungcho.graphql.GraphQLRequest;
import me.test.takehome2022sunkyungcho.graphql.GraphQLResponse;
import me.test.takehome2022sunkyungcho.graphql.GraphqlClient;

import java.util.List;

@RequiredArgsConstructor
public class BitcoinBlockGraphQLLoader implements BitcoinBlockLoader {

    private final GraphqlClient graphqlClient;

    @Override
    public List<BitcoinBlock> load(String dateTime) {
        if (dateTime == null || dateTime.isEmpty()) {
//            임의로 2022-08-19일 이후 데이터를 가지고 오도록 하겠니다.
            dateTime = "2022-08-19T00:00:00Z";
        }
        GraphQLRequest request = new BitqueryRequest("query MyQuery { " +
                "bitcoin { blocks(options: {asc: \"timestamp.time\"}) { " +
                "count blockHash blockSize blockSizeBigInt blockStrippedSize blockVersion blockWeight difficulty height transactionCount " +
                "timestamp(time: {after: \"" + dateTime + "\"}){ time iso8601 } } " +
                "} }");
        GraphQLResponse response = graphqlClient.post(request);
        BitcoinBlock[] bitcoinBlocks = response.getList("/data/bitcoin/blocks", BitcoinBlock[].class);
        return List.of(bitcoinBlocks);
    }
}
