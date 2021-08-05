package com.ampp8800.calculator;

import java.math.BigDecimal;

public class CalculationDataConverter {

    DataConversion dataConversion (String str) {
        double x = 0;
        double y = 0;
        String op = "";

        try{
            String strData[] = str.split(" ");
            if (strData.length>3){throw new Exception();}
            if (!strData[1].equals("+") && !strData[1].equals("-") && !strData[1].equals("*") && !strData[1].equals("/")){throw new Exception();}
            x = Double.parseDouble(strData[0]);
            op = strData[1];
            y = Double.parseDouble(strData[2]);
            if (y == 0 && op.equals("/")){
                System.out.print("Division by zero. ");
                throw new Exception();
            }
            BigDecimal currentDouble1 = new BigDecimal(strData[0]);
            BigDecimal currentDouble2 = new BigDecimal(strData[2]);
            BigDecimal maxDouble = new BigDecimal(Double.MAX_VALUE);
            if (currentDouble1.compareTo(maxDouble) == 1){throw new Exception();}
            if (currentDouble2.compareTo(maxDouble) == 1){throw new Exception();}

        }catch (Exception unused){
            System.out.println("Invalid input string format, re-enter expression");
            op = "error";
        }
        DataConversion dataConversion = new DataConversion(x, y, op);
        return dataConversion;
    }

}
