package me.test.takehome2022sunkyungcho.application;

import lombok.RequiredArgsConstructor;
import me.test.takehome2022sunkyungcho.domain.Diffyculty;
import me.test.takehome2022sunkyungcho.repository.BitcoinBlockQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DifficultyDateLoadService {

    private final BitcoinBlockQueryRepository bitcoinBlockQueryRepository;

    public Diffyculty load() {
        Diffyculty diffyculty = new Diffyculty();
        List<List<Object>> bitcoinBlocks = bitcoinBlockQueryRepository.findAll();
        for (List<Object> bitcoinBlock : bitcoinBlocks) {
            diffyculty.addDate(bitcoinBlock.get(9).toString());
            diffyculty.addDifficulty(Double.parseDouble(bitcoinBlock.get(1).toString()));
        }
        return diffyculty;
    }
}
