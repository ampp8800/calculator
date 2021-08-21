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
                if (!MathematicalFunction.Procedure.ERROR.equals(data.getOp())) {
                    if (MathematicalFunction.Procedure.EXIT.equals(data.getOp())) {
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

        if (MathematicalFunction.Procedure.SUB.equals(data.getOp())) {
            currentData = new BigDecimal(String.valueOf(data.getX().subtract(data.getY())));
        }
        if (MathematicalFunction.Procedure.SUM.equals(data.getOp())) {
            currentData = new BigDecimal(String.valueOf(data.getX().add(data.getY())));
        }
        if (MathematicalFunction.Procedure.DIV.equals(data.getOp())) {
            currentData = new BigDecimal(String.valueOf(data.getX().divide(data.getY(), 9, RoundingMode.HALF_UP)));
        }
        if (MathematicalFunction.Procedure.MUL.equals(data.getOp())) {
            currentData = new BigDecimal(String.valueOf(data.getX().multiply(data.getY())));
        }
        if (MathematicalFunction.Procedure.FAC.equals(data.getOp())) {
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


