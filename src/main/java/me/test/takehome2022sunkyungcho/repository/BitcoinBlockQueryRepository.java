package me.test.takehome2022sunkyungcho.repository;

import java.util.List;

public interface BitcoinBlockQueryRepository {

    String findLastDateTime();

    List<List<Object>> findAll();
}
