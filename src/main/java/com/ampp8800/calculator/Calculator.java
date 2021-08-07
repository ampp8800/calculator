package com.ampp8800.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Calculator {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            boolean newCycle = true;
            while (true) {
                if (newCycle) {
                    System.out.println("enter data in the format (A op B)");
                    CalculationDataConverter calculationDataConverter = new CalculationDataConverter();
                    DataConversion data = calculationDataConverter.dataConversion(reader.readLine());
                    if (!data.getOp().equals("error")) {
                        BigDecimal bigDecimal = calculation(data);
                        BigDecimal maxDouble = new BigDecimal(Double.MAX_VALUE);
                        if (bigDecimal.compareTo(maxDouble) == 1) {
                            System.out.println("out of limits");
                        } else {
                            Transformation transformation = new Transformation(bigDecimal);
                            System.out.println(transformation.getResult());
                            newCycle = false;
                        }
                    }
                }

                if (!newCycle) {
                    System.out.println("proceed? (y/n)");
                    String proceed = reader.readLine();
                    if (proceed.equals("n")) {
                        break;
                    } else if (proceed.equals("y")) {
                        newCycle = true;
                    } else {
                        System.out.println("incorrect input");
                    }
                }
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    static BigDecimal calculation  (DataConversion data){
        BigDecimal maxDouble = new BigDecimal(Double.MAX_VALUE);
        BigDecimal currentDouble = null;
        if (data.getOp().equals("-")){
            currentDouble = new BigDecimal(String.valueOf(data.getX().subtract(data.getY())));
            if (currentDouble.compareTo(maxDouble) == 1){
                currentDouble.add(BigDecimal.valueOf(Double.MAX_VALUE));
            }
        }
        if (data.getOp().equals("+")){
            currentDouble = new BigDecimal(String.valueOf(data.getX().add(data.getY())));
            if (currentDouble.compareTo(maxDouble) == 1){
                currentDouble.add(BigDecimal.valueOf(Double.MAX_VALUE));
            }
        }
        if (data.getOp().equals("/")){
            currentDouble = new BigDecimal(String.valueOf(data.getX().divide(data.getY())));
            if (currentDouble.compareTo(maxDouble) == 1){
                currentDouble.add(BigDecimal.valueOf(Double.MAX_VALUE));
            }
        }
        if (data.getOp().equals("*")){
            currentDouble = new BigDecimal(String.valueOf(data.getX().multiply(data.getY())));
            if (currentDouble.compareTo(maxDouble) == 1){
                currentDouble.add(BigDecimal.valueOf(Double.MAX_VALUE));
            }
        }

        return currentDouble;
    }
}
