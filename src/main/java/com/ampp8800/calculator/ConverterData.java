package com.ampp8800.calculator;

import java.math.BigDecimal;

public class ConverterData {

    static Data dataConversion(String str) {
        BigDecimal x = new BigDecimal(0);
        BigDecimal y = new BigDecimal(0);
        String op = "";

        try {
            String strData[] = str.split(" ");
            if (strData.length == 3) {
                if (strData[1].equals("+") || strData[1].equals("-") || strData[1].equals("*") || strData[1].equals("/")) {
                    x = new BigDecimal(strData[0]);
                    op = strData[1];
                    y = new BigDecimal(strData[2]);
                    if (y.compareTo(new BigDecimal(0)) == 0 && op.equals("/")) {
                        System.out.print("Division by zero. ");
                        op = "error";
                    }

                } else {
                    System.out.println("Invalid input string format, re-enter expression");
                    op = "error";
                }
            } else if (strData.length == 1){
                if (strData[0].lastIndexOf('!') == (strData[0].length()-1)){

                }else{
                    System.out.println("Invalid input string format, re-enter expression");
                    op = "error";
                }
            }else {
                System.out.println("Invalid input string format, re-enter expression");
                op = "error";
            }

        } catch (Exception unused) {
            System.out.println("Invalid input string format, re-enter expression");
            op = "error";
        }

        return new Data(x, y, op);
    }

}
