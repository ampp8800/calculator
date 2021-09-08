package com.ampp8800.calculator;

public class Calculator {


    static Warehouse warehouse;
    static Data data;

    public static void main(String[] args) {
        FileWorker.readFile();
        System.out.println("Enter data in the format (A op B) or (A!)");
        while (true) {
            data = UserStreamProcesson.inputData();
            if (data != null) {
                if (data.getOp() == null) {
                    System.out.println("Invalid input string format, re-enter expression. Operation: A op B / A!, Commands: remember, show, removeall, exit/q");
                    continue;
                }
                warehouse = CommandProcessor.treatment(data);
                if (warehouse != null) {
                    if (warehouse.getResultBD() != null) {
                        System.out.println(warehouse.getResultBD().toPlainString());
                    }
                    if (warehouse.getResultStr() != null) {
                        System.out.println(warehouse.getResultStr());
                    }
                    if (warehouse.getExit()) {
                        break;
                    }
                } else {
                    System.out.println("Invalid input string format, re-enter expression. Operation: A op B / A!, Commands: remember, show, removeall, exit/q");
                }
            } else {
                System.out.println("Invalid input string format, re-enter expression. Operation: A op B / A!, Commands: remember, show, removeall, exit/q");
            }
        }
        FileWorker.writeFile();
        try {
            UserStreamProcesson.closeReader();
        } catch (Exception e) {
        }


    }

}
