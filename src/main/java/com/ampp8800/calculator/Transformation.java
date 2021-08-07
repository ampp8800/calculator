package com.ampp8800.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Transformation {
    private Object result;
    private int FRACTION = 4;

        Transformation(BigDecimal data) {

          BigDecimal result = data.setScale(FRACTION, RoundingMode.HALF_UP).stripTrailingZeros();

//        String resultString =  data.setScale(FRACTION, RoundingMode.HALF_UP).toString();

//        for (int i = 0; i<(FRACTION+1); i++){
//            if (resultString.endsWith("0") || resultString.endsWith(".")){
//                resultString = resultString.substring(0, resultString.length() - 1);
//            }
//        }
        this.result = result;


    }

    public Object getResult() {
        return result;
    }
}
