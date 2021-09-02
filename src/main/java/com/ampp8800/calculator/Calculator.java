package com.ampp8800.calculator;

import java.math.BigDecimal;

public class Calculator {

    static BigDecimal result;
    static Data data;

    public static void main(String[] args) {
        FileWorker.readFile();
        System.out.println("Enter data in the format (A op B) or (A!)");
        while (true) {
            try {
                data = UserStreamProcesson.inputData();
                data = CommandProcessor.treatment(data);
                result = data.getX();
                if (result != null) {
                    System.out.println(result.toPlainString());
                }
                if (data.getStr() != null) {
                    System.out.println(data.getStr());
                }
                if (Operation.Command.EXIT.equals(data.getOp())) {
                    break;
                }
            } catch (Exception exception) {
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


