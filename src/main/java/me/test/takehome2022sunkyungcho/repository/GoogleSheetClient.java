package me.test.takehome2022sunkyungcho.repository;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import lombok.RequiredArgsConstructor;
import me.test.takehome2022sunkyungcho.exception.GoogleSheetException;

import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
public class GoogleSheetClient {

    private final Sheets sheets;
    private final String spreadsheetId;
    private final String range;

    public List<List<Object>> findByRange(String range) {
        try {
            return sheets.spreadsheets()
                    .values()
                    .get(spreadsheetId, range)
                    .execute()
                    .getValues();
        } catch (IOException e) {
            throw new GoogleSheetException(e);
        }
    }


    public List<List<Object>> findAll() {
        try {
            return sheets.spreadsheets()
                    .values()
                    .get(spreadsheetId, range)
                    .execute()
                    .getValues();
        } catch (IOException e) {
            throw new GoogleSheetException(e);
        }
    }
    public AppendValuesResponse append(List<List<Object>> values) {

        try {
            ValueRange body = new ValueRange().setValues(values);
            return sheets.spreadsheets().values().append(spreadsheetId, range, body)
                    .setValueInputOption("RAW")
                    .execute();
        } catch (IOException e) {
            throw new GoogleSheetException(e);
        }
    }

}
