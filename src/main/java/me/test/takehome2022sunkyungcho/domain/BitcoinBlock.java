package me.test.takehome2022sunkyungcho.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class BitcoinBlock {

    private String height;
    private String difficulty;
    private String count;
    private String blockWeight;
    private String blockVersion;
    private String blockStrippedSize;
    private String blockSizeBigInt;
    private String blockSize;
    private String transactionCount;
    private Timestamp timestamp;
    private String blockHash;

    public List<Object> toList() {
        return List.of(height, difficulty, count, blockWeight, blockVersion, blockStrippedSize, blockSizeBigInt, blockSize, transactionCount, timestamp.getIso8601(), blockHash);
    }

    @Getter
    @Setter
    public static class Timestamp {
        private String time;
        private String iso8601;
    }
}
