package com.ampp8800.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class UserStreamProcesson {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Data inputData() {
        Data data = null;
        try {
            String strData[] = UserStreamProcesson.reader.readLine().split(" ");
            if (strData.length == 3) {
                data = getMathData(strData);
            } else if (strData.length == 2) {
                data = getServiceData(strData);
            } else if (strData.length == 1) {
                data = getFactorialOrServiceData(strData);
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return data;
    }

    public static Data getMathData(String[] strData) {
        BigDecimal x = null;
        BigDecimal y = null;
        Operation.Command op = Operation.Command.getFromString(strData[1]);
        if (op != null) {
            if (Operation.CommandType.MATH.equals(op.getCommandType())) {
                x = RepositoryWorker.appropriation(strData[0]);
                y = RepositoryWorker.appropriation(strData[2]);
                if (x == null || y == null) {
                    op = null;
                }
            } else {
                op = null;
            }

        }
        return new Data(x, y, op);
    }

    public static Data getServiceData(String[] strData) {
        Operation.Command op = Operation.Command.getFromString(strData[0]);
        if (op != null) {
            if (!Operation.CommandType.SERVICE.equals(op.getCommandType())) {
                op = null;
            }
        }
        return new Data(strData[1], op);
    }

    public static Data getFactorialOrServiceData(String[] strData) {
        if (strData[0].length() > 1) {
            if (strData[0].lastIndexOf(Operation.Command.FACTORIAL.getOperation()[0]) == (strData[0].length() - 1)) {
                Operation.Command op = null;
                BigDecimal bigDecimal = null;
                if (strData[0].indexOf(".") != -1 || strData[0].indexOf("-") != -1) {
                    op = null;
                    System.out.print("To calculate the factorial. a positive integer is required (A!). ");
                } else {
                    bigDecimal = RepositoryWorker.appropriation(strData[0].substring(0, strData[0].length() - 1));
                    if (bigDecimal != null) {
                        op = Operation.Command.FACTORIAL;
                    }
                }
                return new Data(bigDecimal, op);
            }
        }
        Operation.Command op = Operation.Command.getFromString(strData[0]);
        if (op != null) {
            if (!Operation.CommandType.SERVICE.equals(op.getCommandType())) {
                op = null;
            }
        }
        return new Data(op);
    }

    public static void closeReader() throws IOException {
        reader.close();
    }

    public static void help() {
        System.out.println("the calculator has the following functions");
        System.out.println("possible operators in expression (A op B): +, -, *, /");
        System.out.println("calculate factorial (A): A!");
        System.out.println("create a cell named A: remember A");
        System.out.println("show cell named A: show A");
        System.out.println("clear data store: removeall");
        System.out.println("exit the program: exit, q");
    }

}