
class Transformation {
    private Object result;

    Transformation(Double data) {

        if (data == Double.MAX_VALUE){
            this.result = "out of limits";
        }else if (data % 1 == 0) {
            this.result = data.intValue();
        }else{
            this.result = Math.round(data*10000.0)/10000.0;
        }

    }

    public Object getResult() {
        return result;
    }
}
