package com.ampp8800.calculator;


import java.math.BigDecimal;


public class ConverterData {

    static Data dataConversion(String str) {
        MathematicalFunction.Procedure op = MathematicalFunction.Procedure.ERROR;
        try {
            String strData[] = str.split(" ");
            if (strData.length == 3) {
                return simpleMathData(strData);

            } else if (strData.length == 1) {
                if (strData[0].lastIndexOf('!') == (strData[0].length() - 1)) {
                    return factorialData(strData[0]);
                } else if (MathematicalFunction.Procedure.DEL.getProcedure().equalsIgnoreCase(strData[0])) {
                    Repository.removeRepository();
                    op = MathematicalFunction.Procedure.DEL;
                } else if (MathematicalFunction.Procedure.HELP.getProcedure().equalsIgnoreCase(strData[0])) {
                    help();
                    op = MathematicalFunction.Procedure.HELP;
                } else {
                    op = exit(strData[0]);
                }

            } else if (strData.length == 2) {
                if (MathematicalFunction.Procedure.REM.getProcedure().equalsIgnoreCase(strData[0])) {
                    op = MathematicalFunction.Procedure.REM;
                    recording(strData, Calculator.data, Calculator.result);
                }
                if (MathematicalFunction.Procedure.SHOW.getProcedure().equalsIgnoreCase(strData[0])) {
                    op = MathematicalFunction.Procedure.SHOW;
                    reading(strData[1]);
                }

            } else {
                op = MathematicalFunction.Procedure.ERROR;
            }

        } catch (Exception unused) {
            op = MathematicalFunction.Procedure.ERROR;
        }
        if ((MathematicalFunction.Procedure.ERROR).equals(op)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(op);
    }


    static Data simpleMathData(String strData[]) {
        BigDecimal x = new BigDecimal(0);
        BigDecimal y = new BigDecimal(0);
        MathematicalFunction.Procedure op = MathematicalFunction.Procedure.ERROR;
        if ((MathematicalFunction.Procedure.SUM).getProcedure().equals(strData[1]) || (MathematicalFunction.Procedure.SUB).getProcedure().equals(strData[1]) || (MathematicalFunction.Procedure.MUL).getProcedure().equals(strData[1]) || (MathematicalFunction.Procedure.DIV).getProcedure().equals(strData[1])) {
            x = appropriation(strData[0]);
            y = appropriation(strData[2]);
            op = MathematicalFunction.Procedure.setProcedure(strData[1]);
            if (y.compareTo(new BigDecimal(0)) == 0 && MathematicalFunction.Procedure.DIV.equals(op)) {
                System.out.print("Division by zero. ");
                op = MathematicalFunction.Procedure.ERROR;
            }

        }
        if (MathematicalFunction.Procedure.ERROR.equals(op)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(x, y, op);
    }


    static Data factorialData(String strData) {
        BigDecimal x = new BigDecimal(0);
        MathematicalFunction.Procedure op = MathematicalFunction.Procedure.FAC;
        strData = strData.substring(0, strData.length() - 1);
        if (strData.contains(".") || strData.contains("-")) {
            op = MathematicalFunction.Procedure.ERROR;
            System.out.print("To calculate the factorial. a positive integer is required (A!). ");
        } else {
            x = appropriation(strData);
        }

        if (MathematicalFunction.Procedure.ERROR.equals(op)) {
            System.out.println("Invalid input string format, re-enter expression");
        }
        return new Data(x, op);
    }

    static MathematicalFunction.Procedure exit(String strData) {
        MathematicalFunction.Procedure op = MathematicalFunction.Procedure.ERROR;

        if (("exit").equalsIgnoreCase(strData) || ("q").equalsIgnoreCase(strData)) {

            op = MathematicalFunction.Procedure.EXIT;
            return op;
        }
        return op;

    }

    static void recording(String strData[], Data data, BigDecimal bigDecimal) {

        if (!(data == null) && !(bigDecimal == null)) {
            if (!(MathematicalFunction.Procedure.ERROR).equals(data.getOp())) {
                try {
                    Double.parseDouble(strData[1]);
                    System.out.println("You cannot use numbers for the cell name");
                } catch (Exception unused) {
                    if (strData[1].lastIndexOf('!') != (strData[1].length() - 1)) {
                        Repository.setCell(strData[1], bigDecimal);
                        System.out.println("Add new cell");
                    } else {
                        System.out.println("You cannot use an exclamation mark at the end of a cell name");
                    }
                }
            } else {
                System.out.println("No data to remember");
            }
        } else {
            System.out.println("No data to remember");
        }
    }

    static void reading(String string) {
        if (Repository.getCell(string) != null) {
            System.out.println(string + ": " + Repository.getCell(string));
        } else {
            System.out.println("Cell not found");
        }
    }

    static BigDecimal appropriation(String string) {
        BigDecimal bigDecimal;
        if (Repository.getCell(string) == null) {
            bigDecimal = new BigDecimal(string);
        } else {
            bigDecimal = Repository.getCell(string);
        }
        return bigDecimal;
    }

    static void help(){
        System.out.println("the calculator has the following functions");
        System.out.println("possible operators in expression (A op B): +, -, *, /");
        System.out.println("calculate factorial (A): A!");
        System.out.println("create a cell named A: remembr A");
        System.out.println("show cell named A: show A");
        System.out.println("clear data store: removeall");
        System.out.println("exit the program: exit, q");
    }
}
