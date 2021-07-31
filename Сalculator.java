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
                    DataConversion data = new DataConversion(reader.readLine());
                    if (!data.getOp().equals("error")){

                        System.out.println(new Transformation(calculation(data)).getResult());
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

        } catch (IOException unused) {}


    }
    static Double calculation  (DataConversion data){
        double result = 37;
        BigDecimal maxDouble = new BigDecimal(Double.MAX_VALUE);
        BigDecimal currentDouble = null;
        if (data.getOp().equals("-")){
            currentDouble = new BigDecimal(data.getX() - data.getY());
            if (currentDouble.compareTo(maxDouble) == 1){
                result = Double.MAX_VALUE;
            }else {result = data.getX() - data.getY();}
        }
        if (data.getOp().equals("+")){
            currentDouble = new BigDecimal(data.getX() + data.getY());
            if (currentDouble.compareTo(maxDouble) == 1){
                result = Double.MAX_VALUE;
            }else {result = data.getX() + data.getY();}
        }
        if (data.getOp().equals("/")){
            currentDouble = new BigDecimal(data.getX() / data.getY());
            if (currentDouble.compareTo(maxDouble) == 1){
                result = Double.MAX_VALUE;
            }else {result = data.getX() / data.getY();}
        }
        if (data.getOp().equals("*")){
            currentDouble = new BigDecimal(data.getX() * data.getY());
            if (currentDouble.compareTo(maxDouble) == 1){
                result = Double.MAX_VALUE;
            }else {result = data.getX() * data.getY();}
        }
        System.out.println(currentDouble);
        return result;
    }
}
