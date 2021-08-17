package com.ampp8800.calculator;

import java.math.BigDecimal;

public class ConverterData {

    static Data dataConversion(String str) {
        String op = "";

        try {
            String strData[] = str.split(" ");
            if (strData.length == 3) {
                return simpleMathData(strData);
            } else if (strData.length == 1) {
                return factorialData(strData);
            } else {
                op = "error";
            }

        } catch (Exception unused) {
            op = "error";
        }
        if (op.equals("error")) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(op);
    }

    enum Procedure {
        SUM("+"),
        SUB("-"),
        MUL("*"),
        DIV("/"),
        FAC("!");
        private String procedure;

        Procedure(String procedure) {
            this.procedure = procedure;
        }

        public String getProcedure() {
            return procedure;
        }

    }

    static Data simpleMathData(String strData[]) {
        BigDecimal x = new BigDecimal(0);
        BigDecimal y = new BigDecimal(0);
        String op = "";
        if (strData[1].equals(Procedure.SUM.getProcedure()) || strData[1].equals(Procedure.SUB.getProcedure()) || strData[1].equals(Procedure.MUL.getProcedure()) || strData[1].equals(Procedure.DIV.getProcedure())) {
            x = new BigDecimal(strData[0]);
            op = strData[1];
            y = new BigDecimal(strData[2]);
            if (y.compareTo(new BigDecimal(0)) == 0 && op.equals(Procedure.DIV.getProcedure())) {
                System.out.print("Division by zero. ");
                op = "error";
            }
        } else {
            op = "error";
        }
        if (op.equals("error")) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(x, y, op);
    }

    static Data factorialData(String strData[]) {
        BigDecimal x = new BigDecimal(0);
        String op = "";
        if (strData[0].lastIndexOf('!') == (strData[0].length() - 1)) {
            op = Procedure.FAC.getProcedure();
            strData[0] = strData[0].substring(0, strData[0].length() - 1);
            if (strData[0].indexOf(".") != -1 || strData[0].indexOf("-") != -1) {
                op = "error";
                System.out.print("To calculate the factorial. a positive integer is required (A!). ");
            } else {
                x = new BigDecimal(strData[0]);
            }
        } else {
            op = "error";
        }
        if (op.equals("error")) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(x, op);
    }

}
