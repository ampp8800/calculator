package com.ampp8800.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean newCycle = true;
            while (true) {
                if (newCycle) {
                    System.out.println("Enter data in the format (A op B) or (A!)");
                    Data data = ConverterData.dataConversion(reader.readLine());
                    if (!data.getOp().equals("error")) {
                        BigDecimal bigDecimal = calculation(data);
                        bigDecimal = transformation(bigDecimal);
                        System.out.println(bigDecimal.toPlainString());
                        newCycle = false;

                    }
                }

                if (!newCycle) {
                    System.out.println("Proceed? (y/n)");
                    String proceed = reader.readLine();
                    if (proceed.equals("n")) {
                        break;
                    } else if (proceed.equals("y")) {
                        newCycle = true;
                    } else {
                        System.out.println("Incorrect input");
                    }
                }
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static BigDecimal calculation(Data data) {
        BigDecimal currentData = null;

        if (data.getOp().equals(ConverterData.Procedure.SUB.getProcedure())) {
            currentData = new BigDecimal(String.valueOf(data.getX().subtract(data.getY())));
        }
        if (data.getOp().equals(ConverterData.Procedure.SUM.getProcedure())) {
            currentData = new BigDecimal(String.valueOf(data.getX().add(data.getY())));
        }
        if (data.getOp().equals(ConverterData.Procedure.DIV.getProcedure())) {
            currentData = new BigDecimal(String.valueOf(data.getX().divide(data.getY(), 9, RoundingMode.HALF_UP)));
        }
        if (data.getOp().equals(ConverterData.Procedure.MUL.getProcedure())) {
            currentData = new BigDecimal(String.valueOf(data.getX().multiply(data.getY())));
        }
        if (data.getOp().equals(ConverterData.Procedure.FAC.getProcedure())) {
            currentData = calculateFactorial(data.getX());
        }

        return currentData;
    }

    static BigDecimal transformation(BigDecimal data) {

        int FRACTION = 4;
        data = data.setScale(FRACTION, RoundingMode.HALF_UP).stripTrailingZeros();
        return data;
    }

    static BigDecimal calculateFactorial(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.valueOf(0)) == 0) {
            bigDecimal = new BigDecimal(1);
        } else {
            bigDecimal = recursion(bigDecimal);
        }
        return bigDecimal;
    }

    static BigDecimal recursion(BigDecimal bigDecimal) {

        BigDecimal counter = new BigDecimal(String.valueOf(bigDecimal));

        if (counter.compareTo(BigDecimal.valueOf(1)) > 0) {
            counter = new BigDecimal(String.valueOf(counter.subtract(new BigDecimal(1))));
            counter = recursion(counter);
            bigDecimal = new BigDecimal(String.valueOf(bigDecimal.multiply(counter)));
        }
        return bigDecimal;
    }
}


