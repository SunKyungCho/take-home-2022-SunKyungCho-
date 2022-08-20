package me.test.takehome2022sunkyungcho.controller;

import lombok.RequiredArgsConstructor;
import me.test.takehome2022sunkyungcho.application.DifficultyDateLoadService;
import me.test.takehome2022sunkyungcho.domain.Diffyculty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DifficultyController {

    private final DifficultyDateLoadService difficultyDateLoadService;

    @GetMapping("/difficulty")
    public ResponseEntity<Diffyculty> getDifficulty() {
        return ResponseEntity.ok(difficultyDateLoadService.load());
    }
}
