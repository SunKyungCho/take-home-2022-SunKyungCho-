package me.test.takehome2022sunkyungcho.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Diffyculty {

    private final List<String> date = new ArrayList<>();
    private final List<Double> difficulty = new ArrayList<>();


    public void addDate(String date) {
        this.date.add(date);
    }

    public void addDifficulty(Double difficulty) {
        this.difficulty.add(difficulty);
    }
}
