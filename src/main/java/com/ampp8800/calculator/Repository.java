package com.ampp8800.calculator;

import java.math.BigDecimal;
import java.util.HashMap;

public class Repository {
    private static HashMap<String, BigDecimal> repository = new HashMap<>();

    static void setCell(String string, BigDecimal bigDecimal) {
        repository.put(string, bigDecimal);
    }
    static BigDecimal getCell(String string) {
        return repository.get(string);
    }


}
