class Transformation {
    private Object result;

    Transformation(Double data) {
        if (data % 1 == 0) {
            this.result = (int) Math.round(data);
        }else if (data == 1/0.0 || data >= Float.MAX_VALUE){
            this.result = "out-of-value";
        }else{
            this.result = Math.round(data*10000.0)/10000.0;
        }
    }

    public Object getResult() {
        return result;
    }
}
