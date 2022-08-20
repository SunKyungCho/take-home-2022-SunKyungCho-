package me.test.takehome2022sunkyungcho.application;

import me.test.takehome2022sunkyungcho.domain.BitcoinBlock;

import java.util.List;

public interface BitcoinBlockLoader {

    List<BitcoinBlock> load(String dateTime);
}
