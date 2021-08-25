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
                    RepositoryWorker.help();
                    op = MathematicalFunction.Procedure.HELP;
                } else {
                    op = exit(strData[0]);
                }

            } else if (strData.length == 2) {
                if (MathematicalFunction.Procedure.REM.getProcedure().equalsIgnoreCase(strData[0])) {
                    op = MathematicalFunction.Procedure.REM;
                    RepositoryWorker.recording(strData, Calculator.data, Calculator.result);
                }
                if (MathematicalFunction.Procedure.SHOW.getProcedure().equalsIgnoreCase(strData[0])) {
                    op = MathematicalFunction.Procedure.SHOW;
                    RepositoryWorker.reading(strData[1]);
                }

            } else {
                op = MathematicalFunction.Procedure.ERROR;
            }

        } catch (Exception unused) {
            op = MathematicalFunction.Procedure.ERROR;
        }

        return new Data(op);
    }


    static Data simpleMathData(String strData[]) {
        BigDecimal x = new BigDecimal(0);
        BigDecimal y = new BigDecimal(0);
        MathematicalFunction.Procedure op = MathematicalFunction.Procedure.ERROR;
        if ((MathematicalFunction.Procedure.SUM).getProcedure().equals(strData[1]) || (MathematicalFunction.Procedure.SUB).getProcedure().equals(strData[1]) || (MathematicalFunction.Procedure.MUL).getProcedure().equals(strData[1]) || (MathematicalFunction.Procedure.DIV).getProcedure().equals(strData[1])) {
            x = RepositoryWorker.appropriation(strData[0]);
            y = RepositoryWorker.appropriation(strData[2]);
            op = MathematicalFunction.Procedure.setProcedure(strData[1]);
            if (y.compareTo(new BigDecimal(0)) == 0 && MathematicalFunction.Procedure.DIV.equals(op)) {
                System.out.print("Division by zero. ");
                op = MathematicalFunction.Procedure.ERROR;
            }

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
            x = RepositoryWorker.appropriation(strData);
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


}
