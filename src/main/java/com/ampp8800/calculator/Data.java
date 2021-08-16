package com.ampp8800.calculator;

import java.math.BigDecimal;

class Data {
    private BigDecimal x;
    private BigDecimal y;
    private String op = "";

    public Data(BigDecimal x, BigDecimal y, String op) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
        this.op = op;
    }

    public Data(BigDecimal x, String op) {
        this.x = x;
        this.op = op;
    }

    public Data(String op) {
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
