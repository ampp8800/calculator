package com.ampp8800.calculator;

import java.math.BigDecimal;

class Data {
    private BigDecimal x;
    private BigDecimal y;
    private MathematicalFunction.Procedure op;

    public Data(BigDecimal x, BigDecimal y, MathematicalFunction.Procedure op) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
        this.op = op;
    }

    public Data(BigDecimal x, MathematicalFunction.Procedure op) {
        this.x = x;
        this.op = op;
    }

    public Data(MathematicalFunction.Procedure op) {
        this.op = op;
    }


    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public MathematicalFunction.Procedure getOp() {
        return op;
    }

}
