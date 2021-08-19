package com.ampp8800.calculator;


import java.math.BigDecimal;

public class ConverterData {

    static Data dataConversion(String str) {
        Procedure op;
        try {
            String strData[] = str.split(" ");
            if (strData.length == 3) {
                return simpleMathData(strData);
            } else if (strData.length == 1) {
                return factorialData(strData);
            } else {
                op = Procedure.ERROR;
            }

        } catch (Exception unused) {
            op = Procedure.ERROR;
        }
        if (op.equals(Procedure.ERROR)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(op);
    }

    enum Procedure {
        SUM("+"),
        SUB("-"),
        MUL("*"),
        DIV("/"),
        FAC("!"),
        ERROR("error");
        private String procedure;

        Procedure(String procedure) {
            this.procedure = procedure;
        }

        public String getProcedure() {
            return procedure;
        }

        static Procedure setProcedure(String procedure) {
            switch (procedure) {
                case "+":
                    return Procedure.SUM;
                case "-":
                    return Procedure.SUB;
                case "*":
                    return Procedure.MUL;
                case "/":
                    return Procedure.DIV;
                case "!":
                    return Procedure.FAC;
                default:
                    return Procedure.ERROR;
            }

        }

    }

    static Data simpleMathData(String strData[]) {
        BigDecimal x = new BigDecimal(0);
        BigDecimal y = new BigDecimal(0);
        Procedure op = Procedure.ERROR;
        if (strData[1].equals(Procedure.SUM.getProcedure()) || strData[1].equals(Procedure.SUB.getProcedure()) || strData[1].equals(Procedure.MUL.getProcedure()) || strData[1].equals(Procedure.DIV.getProcedure())) {
            x = new BigDecimal(strData[0]);
            op = Procedure.setProcedure(strData[1]);
            y = new BigDecimal(strData[2]);
            if (y.compareTo(new BigDecimal(0)) == 0 && op.equals(Procedure.DIV)) {
                System.out.print("Division by zero. ");
                op = Procedure.ERROR;
            }

        }
        if (op.equals(Procedure.ERROR)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(x, y, op);
    }


    static Data factorialData(String strData[]) {
        BigDecimal x = new BigDecimal(0);
        Procedure op = Procedure.ERROR;
        if (strData[0].lastIndexOf('!') == (strData[0].length() - 1)) {
            op = Procedure.FAC;
            strData[0] = strData[0].substring(0, strData[0].length() - 1);
            if (strData[0].indexOf(".") != -1 || strData[0].indexOf("-") != -1) {
                op = Procedure.ERROR;
                System.out.print("To calculate the factorial. a positive integer is required (A!). ");
            } else {
                x = new BigDecimal(strData[0]);
            }
        }
        if (op.equals(Procedure.ERROR)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(x, op);
    }

}
