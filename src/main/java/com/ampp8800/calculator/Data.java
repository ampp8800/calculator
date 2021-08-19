package com.ampp8800.calculator;

import java.math.BigDecimal;

class Data {
    private BigDecimal x;
    private BigDecimal y;
    private ConverterData.Procedure op;

    public Data(BigDecimal x, BigDecimal y, ConverterData.Procedure op) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
        this.op = op;
    }

    public Data(BigDecimal x, ConverterData.Procedure op) {
        this.x = x;
        this.op = op;
    }

    public Data(ConverterData.Procedure op) {
        this.op = op;
    }


    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public ConverterData.Procedure getOp() {
        return op;
    }

}
