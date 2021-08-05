package com.ampp8800.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Transformation {
    private String result;
    private int FRACTION = 4;

        Transformation(BigDecimal data) {


        String resultString =  data.setScale(FRACTION, RoundingMode.HALF_UP).toString();

        for (int i = 0; i<(FRACTION+1); i++){
            if (resultString.endsWith("0") || resultString.endsWith(".")){
                resultString = resultString.substring(0, resultString.length() - 1);
            }
        }
        this.result = resultString;


    }

    public String getResult() {
        return result;
    }
}
