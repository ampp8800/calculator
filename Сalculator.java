import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        double result = 37707;
        if (data.getOp().equals("-")){ result = data.getX() - data.getY();}
        if (data.getOp().equals("+")){ result = data.getX() + data.getY();}
        if (data.getOp().equals("/")){ result = data.getX() / data.getY();}
        if (data.getOp().equals("*")){ result = data.getX() * data.getY();}
        return result;
    }


}
