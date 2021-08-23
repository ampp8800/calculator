package com.ampp8800.calculator;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Calculator {

    static BigDecimal result;
    static Data data;

    public static void main(String[] args) {
        readFile();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter data in the format (A op B) or (A!)");
            while (true) {
                data = ConverterData.dataConversion(reader.readLine());
                if (!MathematicalFunction.Procedure.ERROR.equals(data.getOp())) {
                    if (MathematicalFunction.Procedure.EXIT.equals(data.getOp())) {
                        break;
                    }
                    if (!(MathematicalFunction.Procedure.REM.equals(data.getOp()) || MathematicalFunction.Procedure.SHOW.equals(data.getOp()) || MathematicalFunction.Procedure.DEL.equals(data.getOp()))) {
                        result = transformation(calculation(data));
                        System.out.println(result.toPlainString());
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        writeFile();

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

    static void readFile() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("Repository.txt"))) {
            while (true) {
                String line[] = fileReader.readLine().split("=");
                BigDecimal bigDecimal = new BigDecimal(line[1]);
                Repository.setCell(line[0], bigDecimal);
            }
        } catch (Exception unused) {
        }
    }

    static void writeFile() {
        try (FileWriter writer = new FileWriter("Repository.txt", false)) {
            for (Map.Entry<String, BigDecimal> entry : Repository.getRepository().entrySet()) {
                writer.write(entry + "\n");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}


