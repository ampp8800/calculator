package com.ampp8800.calculator;


import java.math.BigDecimal;

public class ConverterData {

    static Data dataConversion(String str) {
        MathematicalFunction.Procedure op;
        try {
            String strData[] = str.split(" ");
            if (strData.length == 3) {
                return simpleMathData(strData);
            } else if (strData.length == 1) {
                return factorialData(strData[0]);
            } else {
                op = MathematicalFunction.Procedure.ERROR;
            }

        } catch (Exception unused) {
            op = MathematicalFunction.Procedure.ERROR;
        }
        if (op.equals(MathematicalFunction.Procedure.ERROR)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(op);
    }


    static Data simpleMathData(String strData[]) {
        BigDecimal x = new BigDecimal(0);
        BigDecimal y = new BigDecimal(0);
        MathematicalFunction.Procedure op = MathematicalFunction.Procedure.ERROR;
        if (strData[1].equals(MathematicalFunction.Procedure.SUM.getProcedure()) || strData[1].equals(MathematicalFunction.Procedure.SUB.getProcedure()) || strData[1].equals(MathematicalFunction.Procedure.MUL.getProcedure()) || strData[1].equals(MathematicalFunction.Procedure.DIV.getProcedure())) {
            x = new BigDecimal(strData[0]);
            op = MathematicalFunction.Procedure.setProcedure(strData[1]);
            y = new BigDecimal(strData[2]);
            if (y.compareTo(new BigDecimal(0)) == 0 && op.equals(MathematicalFunction.Procedure.DIV)) {
                System.out.print("Division by zero. ");
                op = MathematicalFunction.Procedure.ERROR;
            }

        }
        if (op.equals(MathematicalFunction.Procedure.ERROR)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(x, y, op);
    }


    static Data factorialData(String strData) {
        BigDecimal x = new BigDecimal(0);
        MathematicalFunction.Procedure op = MathematicalFunction.Procedure.ERROR;
        if (strData.lastIndexOf('!') == (strData.length() - 1)) {
            op = MathematicalFunction.Procedure.FAC;
            strData = strData.substring(0, strData.length() - 1);
            if (strData.indexOf(".") != -1 || strData.indexOf("-") != -1) {
                op = MathematicalFunction.Procedure.ERROR;
                System.out.print("To calculate the factorial. a positive integer is required (A!). ");
            } else {
                x = new BigDecimal(strData);
            }
        } else {
            op = exit(strData);
        }
        if (op.equals(MathematicalFunction.Procedure.ERROR)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(x, op);
    }

    static MathematicalFunction.Procedure exit(String strData) {
        MathematicalFunction.Procedure op = MathematicalFunction.Procedure.ERROR;
        if (strData.equals("exit") || strData.equals("q")) {
            op = MathematicalFunction.Procedure.EXIT;
        }
        return op;

    }

}
