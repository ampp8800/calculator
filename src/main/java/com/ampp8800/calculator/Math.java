package com.ampp8800.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Math {
    public static BigDecimal definition(Data data) {
        if (data.getY() == null) {
            if (Operation.Command.FACTORIAL.equals(data.getOp())) {
                if (data.getX().compareTo(new BigDecimal(0)) >= 0
                        && data.getX().toPlainString().equals((data.getX().divide(new BigDecimal(1), 0, RoundingMode.HALF_UP)).toPlainString())) {
                    return calculateFactorial(data.getX());
                } else {
                    System.out.print("To calculate the factorial. a positive integer is required (A!). ");
                }
            }
        }
        return calculation(data);
    }

    public static BigDecimal calculateFactorial(BigDecimal bigDecimal) {
        BigDecimal result = new BigDecimal(1);
        if (bigDecimal.compareTo(BigDecimal.valueOf(1)) < 0) {
            return result;
        }
        result = new BigDecimal(String.valueOf(bigDecimal.multiply(calculateFactorial(bigDecimal.subtract(BigDecimal.valueOf(1))))));
        return result;
    }

    static BigDecimal calculation(Data data) {
        BigDecimal currentData = null;

        if (Operation.Command.SUBTRACTION.equals(data.getOp())) {
            currentData = new BigDecimal(String.valueOf(data.getX().subtract(data.getY())));
        }
        if (Operation.Command.SUM.equals(data.getOp())) {
            currentData = new BigDecimal(String.valueOf(data.getX().add(data.getY())));
        }
        if (Operation.Command.DIVISION.equals(data.getOp())) {
            if (data.getY().compareTo(new BigDecimal(0)) != 0) {
                currentData = new BigDecimal(String.valueOf(data.getX().divide(data.getY(), 4, RoundingMode.HALF_UP)));
            }
        }
        if (Operation.Command.MULTIPLICATION.equals(data.getOp())) {
            currentData = new BigDecimal(String.valueOf(data.getX().multiply(data.getY())));
        }
        return currentData.setScale(4, RoundingMode.HALF_UP).stripTrailingZeros();
    }
}
