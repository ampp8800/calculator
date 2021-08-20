package com.ampp8800.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter data in the format (A op B) or (A!)");
            while (true) {
                Data data = ConverterData.dataConversion(reader.readLine());
                if (!data.getOp().equals(MathematicalFunction.Procedure.ERROR)) {
                    if (data.getOp().equals(MathematicalFunction.Procedure.EXIT)){
                        break;
                    }
                    BigDecimal bigDecimal = calculation(data);
                    bigDecimal = transformation(bigDecimal);
                    System.out.println(bigDecimal.toPlainString());
                }
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static BigDecimal calculation(Data data) {
        BigDecimal currentData = null;

        if (data.getOp().equals(MathematicalFunction.Procedure.SUB)) {
            currentData = new BigDecimal(String.valueOf(data.getX().subtract(data.getY())));
        }
        if (data.getOp().equals(MathematicalFunction.Procedure.SUM)) {
            currentData = new BigDecimal(String.valueOf(data.getX().add(data.getY())));
        }
        if (data.getOp().equals(MathematicalFunction.Procedure.DIV)) {
            currentData = new BigDecimal(String.valueOf(data.getX().divide(data.getY(), 9, RoundingMode.HALF_UP)));
        }
        if (data.getOp().equals(MathematicalFunction.Procedure.MUL)) {
            currentData = new BigDecimal(String.valueOf(data.getX().multiply(data.getY())));
        }
        if (data.getOp().equals(MathematicalFunction.Procedure.FAC)) {
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
        BigDecimal result = new BigDecimal(1);
        if (bigDecimal.compareTo(BigDecimal.valueOf(1)) < 0) {
            return result;
        }
        result = new BigDecimal(String.valueOf(bigDecimal.multiply(calculateFactorial(bigDecimal.subtract(BigDecimal.valueOf(1))))));
        return result;
    }

}


