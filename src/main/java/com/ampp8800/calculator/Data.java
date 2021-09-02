package com.ampp8800.calculator;

import java.math.BigDecimal;

class Data {
    private BigDecimal x;
    private BigDecimal y;
    private String str;
    private Operation.Command op;

    public Data(BigDecimal x, BigDecimal y, Operation.Command op) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
        this.op = op;
    }

    public Data(String str, Operation.Command op) {
        this.str = str;
        this.op = op;
    }

    public Data(BigDecimal x, Operation.Command op) {
        this.x = x;
        this.op = op;
    }

    public Data(Operation.Command op) {
        this.op = op;
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public String getStr() {
        return str;
    }

    public Operation.Command getOp() {
        return op;
    }

}
