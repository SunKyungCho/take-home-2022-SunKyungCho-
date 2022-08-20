package me.test.takehome2022sunkyungcho.application;

import lombok.RequiredArgsConstructor;
import me.test.takehome2022sunkyungcho.domain.BitcoinBlock;
import me.test.takehome2022sunkyungcho.repository.BitcoinBlockQueryRepository;
import me.test.takehome2022sunkyungcho.repository.BitconinBlockCommandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataWriteService {

    private final BitcoinBlockLoader bitcoinBlockLoader;
    private final BitconinBlockCommandRepository bitconinBlockCommandRepository;
    private final BitcoinBlockQueryRepository bitcoinBlockQueryRepository;

    public void writeData() {
        String lastDateTime = bitcoinBlockQueryRepository.findLastDateTime();
        List<BitcoinBlock> bitcoinBlocks = bitcoinBlockLoader.load(lastDateTime);
        bitconinBlockCommandRepository.save(bitcoinBlocks);
    }

}
