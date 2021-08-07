package com.ampp8800.calculator;

import java.math.BigDecimal;

public class DataConversion {
    private BigDecimal x;
    private BigDecimal y;
    private String op = "";

    public DataConversion(BigDecimal x, BigDecimal y, String op) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
        this.op = op;
    }



    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public String getOp() {
        return op;
    }

}
