package me.test.takehome2022sunkyungcho.repository;

import me.test.takehome2022sunkyungcho.domain.BitcoinBlock;

import java.util.List;

public interface BitconinBlockCommandRepository {


    void save(List<BitcoinBlock> bitcoinBlocks);
}
