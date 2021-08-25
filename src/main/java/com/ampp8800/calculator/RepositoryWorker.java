package com.ampp8800.calculator;

import java.math.BigDecimal;

public class RepositoryWorker {
    static void recording(String strData[], Data data, BigDecimal bigDecimal) {

        if (!(data == null) && !(bigDecimal == null) && !bigDecimal.equals(null)) {
            try {
                Double.parseDouble(strData[1]);
                System.out.println("You cannot use numbers for the cell name");
            } catch (Exception unused) {
                if (strData[1].lastIndexOf('!') != (strData[1].length() - 1)) {
                    Repository.setCell(strData[1], bigDecimal);
                    System.out.print("Add new cell ");
                    reading(strData[1]);
                } else {
                    System.out.println("You cannot use an exclamation mark at the end of a cell name");
                }
            }
        } else {
            System.out.println("No data to remember");
        }
    }

    static void reading(String string) {
        if (Repository.getCell(string) != null) {
            System.out.println(string + ": " + Repository.getCell(string).toPlainString());
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
        System.out.println("create a cell named A: remember A");
        System.out.println("show cell named A: show A");
        System.out.println("clear data store: removeall");
        System.out.println("exit the program: exit, q");
    }
}
