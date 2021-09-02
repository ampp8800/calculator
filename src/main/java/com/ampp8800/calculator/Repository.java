package com.ampp8800.calculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class Repository {
    private static HashMap<String, BigDecimal> repository = new HashMap<>();

    static void setCell(String string, BigDecimal bigDecimal) {
        repository.put(string, bigDecimal);
    }

    static BigDecimal getCell(String string) {
        return repository.get(string);
    }

    static HashMap<String, BigDecimal> getRepository() {
        return repository;
    }

    static void removeRepository() {
        HashMap<String, BigDecimal> copy = new HashMap<>(repository);
        for (Map.Entry<String, BigDecimal> entry : copy.entrySet()) {
            repository.remove(entry.getKey());
        }
    }

}
