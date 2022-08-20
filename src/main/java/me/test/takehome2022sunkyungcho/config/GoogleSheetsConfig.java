package me.test.takehome2022sunkyungcho.config;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import me.test.takehome2022sunkyungcho.exception.GoogleSheetException;
import me.test.takehome2022sunkyungcho.repository.GoogleSheetClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;


@Configuration
public class GoogleSheetsConfig {

    private static final String SERVICE_ACCOUNT_FILE_PATH = "/service_account.json";

    @Bean
    public GoogleSheetClient googleSheetClient() throws IOException {
        return new GoogleSheetClient(
                sheets(),
                "10aVcAx5QWv5rjNJELfjawJwAVEvBypYhyJSD9hpsv0A",
                "Bitcoin!A2:K"
        );
    }

    @Bean
    public Sheets sheets() throws IOException {
        InputStream in = GoogleSheetClient.class.getResourceAsStream(SERVICE_ACCOUNT_FILE_PATH);
        if (in == null) {
            throw new GoogleSheetException("Resource not found: " + SERVICE_ACCOUNT_FILE_PATH);
        }
        ServiceAccountCredentials serviceAccountCredentials = ServiceAccountCredentials.fromStream(in);
        GoogleCredentials credentials = serviceAccountCredentials.createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(credentials);
        return new Sheets.Builder(new NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                requestInitializer)
                .setApplicationName("Bitquery")
                .build();
    }


}
