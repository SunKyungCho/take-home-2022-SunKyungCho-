package me.test.takehome2022sunkyungcho.repository;

import com.google.api.services.sheets.v4.Sheets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class GoogleSheetClientTest {

    @Autowired
    Sheets sheets;

    @Test
    void read_range_google_sheets() {
        final String spreadsheetId = "10aVcAx5QWv5rjNJELfjawJwAVEvBypYhyJSD9hpsv0A";
        final String range = "Bitcoin!A:C";
        GoogleSheetClient googleSheetClient = new GoogleSheetClient(sheets, spreadsheetId, "Bitcoin!A:C");

        List<List<Object>> read = googleSheetClient.findByRange("Bitcoin!J2:J");
        List<Object> objects = read.get(read.size() - 1);
        System.out.println();
    }

    @Test
    @DisplayName("구글스프레드시트에 row를 추가할 수 있어야 한다")
    void write_google_sheets() {

        final String spreadsheetId = "10aVcAx5QWv5rjNJELfjawJwAVEvBypYhyJSD9hpsv0A";
        final String range = "Bitcoin!A:C";
        GoogleSheetClient googleSheetClient = new GoogleSheetClient(sheets, spreadsheetId, range);
        googleSheetClient.append(List.of(List.of("1", "2", "3")));
        System.out.println();
    }

    @Test
    @DisplayName("구글스프레드시트에서 row를 읽어올 수 있어야 한다")
    void read_from_google_sheets() {
        final String spreadsheetId = "10aVcAx5QWv5rjNJELfjawJwAVEvBypYhyJSD9hpsv0A";
        final String range = "Bitcoin!A:C";
        GoogleSheetClient googleSheetClient = new GoogleSheetClient(sheets, spreadsheetId, range);
        List<List<Object>> read = googleSheetClient.findAll();
    }

}