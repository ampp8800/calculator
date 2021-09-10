package com.ampp8800.calculator;

import java.math.BigDecimal;

public class Warehouse {
    private BigDecimal resultBD;
    private String resultStr;
    private boolean exit;

    public Warehouse() {
    }

    public Warehouse(String resultStr) {
        this.resultStr = resultStr;

    }

    public Warehouse(BigDecimal resultBD) {
        this.resultBD = resultBD;

    }

    public Warehouse(String resultStr, boolean exit) {
        this.resultStr = resultStr;
        this.exit = exit;
    }

    public BigDecimal getResultBD() {
        return resultBD;
    }

    public String getResultStr() {
        return resultStr;
    }

    public boolean getExit() {
        return exit;
    }

}
