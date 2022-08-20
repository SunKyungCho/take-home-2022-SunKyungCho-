package me.test.takehome2022sunkyungcho.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import me.test.takehome2022sunkyungcho.application.BitcoinBlockGraphQLLoader;
import me.test.takehome2022sunkyungcho.application.BitcoinBlockLoader;
import me.test.takehome2022sunkyungcho.graphql.GraphqlClient;
import me.test.takehome2022sunkyungcho.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public GraphqlClient graphqlClient() {
        return new GraphqlClient(new RestTemplate(), new ObjectMapper());
    }

    @Bean
    public BitcoinBlockLoader bitcoinBlockLoader() {
        return new BitcoinBlockGraphQLLoader(graphqlClient());
    }

    @Bean
    public BitconinBlockCommandRepository bitconinBlockRepository(GoogleSheetClient googleSheetClient) {
        return new BitcoinBlockGoogleSheetsCommandRepository(googleSheetClient);
    }

    @Bean
    public BitcoinBlockQueryRepository bitcoinBlockQueryRepository(GoogleSheetClient googleSheetClient) {
        return new BitcoinBlockGoogleSheetsQueryRepository(googleSheetClient);
    }
}
