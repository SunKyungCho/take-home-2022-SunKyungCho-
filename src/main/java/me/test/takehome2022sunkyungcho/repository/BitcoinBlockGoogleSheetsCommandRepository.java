package me.test.takehome2022sunkyungcho.repository;

import lombok.RequiredArgsConstructor;
import me.test.takehome2022sunkyungcho.domain.BitcoinBlock;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BitcoinBlockGoogleSheetsCommandRepository implements BitconinBlockCommandRepository {

    private final GoogleSheetClient googleSheetClient;



    @Override
    public void save(List<BitcoinBlock> bitcoinBlocks) {
        List<List<Object>> values = new ArrayList<>();

        for (BitcoinBlock bitcoinBlock : bitcoinBlocks) {
            values.add(bitcoinBlock.toList());
        }
        googleSheetClient.append(values);
    }
}
