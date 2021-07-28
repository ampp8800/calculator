
class DataConversion {
    private double x;
    private double y;
    private String op = "";
    DataConversion(String str) {
        try{
            String strData[] = str.split(" ");
            if (strData.length>3){throw new Exception();}
            if (!strData[1].equals("+") && !strData[1].equals("-") && !strData[1].equals("*") && !strData[1].equals("/")){throw new Exception();}
            this.x = Double.parseDouble(strData[0]);
            this.op = strData[1];
            this.y = Double.parseDouble(strData[2]);
        }catch (Exception unused){
            System.out.println("Invalid input string format, re-enter expression");
            this.op = "error";
        }
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    String getOp() {
        return op;
    }
}
