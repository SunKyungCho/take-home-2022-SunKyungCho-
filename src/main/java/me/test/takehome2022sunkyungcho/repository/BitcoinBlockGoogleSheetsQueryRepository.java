package me.test.takehome2022sunkyungcho.repository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BitcoinBlockGoogleSheetsQueryRepository implements BitcoinBlockQueryRepository{
    private final GoogleSheetClient googleSheetClient;

    @Override
    public String findLastDateTime() {
        List<List<Object>> read = googleSheetClient.findByRange("Bitcoin!J2:J");
        if(read == null || read.isEmpty()) {
            return "";
        }
        List<Object> timastamp = read.get(read.size() - 1);
        return timastamp.get(0).toString();
    }

    @Override
    public List<List<Object>> findAll() {
        return googleSheetClient.findAll();
    }
}
