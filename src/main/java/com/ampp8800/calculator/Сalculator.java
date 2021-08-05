package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Сalculator {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true) {
                System.out.println("enter data in the format (A op B)");
                while (true) {
                    CalculationDataConverter calculationDataConverter = new CalculationDataConverter();
                    DataConversion data = calculationDataConverter.dataConversion(reader.readLine());
                    if (!data.getOp().equals("error")){
                        BigDecimal bigDecimal = calculation(data);
                        BigDecimal maxDouble = new BigDecimal(Double.MAX_VALUE);
                        if (bigDecimal.compareTo(maxDouble) == 1){
                            System.out.println("out of limits");
                        }else{
                            Transformation transformation = new Transformation(bigDecimal);
                            System.out.println(transformation.getResult());
                        }

                        break;
                    }
                }
                while (true) {
                    System.out.println("proceed? (y/n)");
                    String proceed = reader.readLine();
                    if (proceed.equals("n")) {
                        System.exit(0);
                    } else if (proceed.equals("y")) {
                        break;
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
            currentDouble = new BigDecimal(data.getX() - data.getY());
            if (currentDouble.compareTo(maxDouble) == 1){
                currentDouble.add(BigDecimal.valueOf(Double.MAX_VALUE));
            }
        }
        if (data.getOp().equals("+")){
            currentDouble = new BigDecimal(data.getX() + data.getY());
            if (currentDouble.compareTo(maxDouble) == 1){
                currentDouble.add(BigDecimal.valueOf(Double.MAX_VALUE));
            }
        }
        if (data.getOp().equals("/")){
            currentDouble = new BigDecimal(data.getX() / data.getY());
            if (currentDouble.compareTo(maxDouble) == 1){
                currentDouble.add(BigDecimal.valueOf(Double.MAX_VALUE));
            }
        }
        if (data.getOp().equals("*")){
            currentDouble = new BigDecimal(data.getX() * data.getY());
            if (currentDouble.compareTo(maxDouble) == 1){
                currentDouble.add(BigDecimal.valueOf(Double.MAX_VALUE));
            }
        }

        return currentDouble;
    }
}
