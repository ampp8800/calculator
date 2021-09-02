package com.ampp8800.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class UserStreamProcesson {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Data inputData() {
        Operation.Command op = null;
        try {

            String strData[] = UserStreamProcesson.reader.readLine().split(" ");


            if (strData.length == 3) {
                BigDecimal x = RepositoryWorker.appropriation(strData[0]);
                BigDecimal y = RepositoryWorker.appropriation(strData[2]);
                op = Operation.Command.getFromString(strData[1]);
                if (!Operation.CommandType.MATH.equals(op.getCommandType())) {
                    op = null;
                }
                return new Data(x, y, op);
            }

            if (strData.length == 2) {
                op = Operation.Command.getFromString(strData[0]);
                if (!Operation.CommandType.SERVICE.equals(op.getCommandType())) {
                    op = null;
                }
                return new Data(strData[1], op);
            }

            if (strData.length == 1) {
                if (strData[0].lastIndexOf(Operation.Command.FACTORIAL.getOperation()) == (strData[0].length() - 1)) {
                    op = Operation.Command.FACTORIAL;
                    BigDecimal x = RepositoryWorker.appropriation(strData[0].substring(0, strData[0].length() - 1));
                    return new Data(x, op);
                }
                op = Operation.Command.getFromString(strData[0]);
                if (!Operation.CommandType.SERVICE.equals(op.getCommandType())) {
                    op = null;
                }
                return new Data(op);
            }

        } catch (IOException exception) {
            exception.printStackTrace();
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
