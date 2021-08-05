package Calculator;

public class DataConversion {
    private double x;
    private double y;
    private String op = "";

    public DataConversion(double x, double y, String op) {
        this.x = x;
        this.y = y;
        this.op = op;
    }



    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getOp() {
        return op;
    }

}
