import java.math.BigDecimal;
import java.math.RoundingMode;

class Transformation {
    private Object result;
    BigDecimal maxDouble = new BigDecimal(Double.MAX_VALUE);
    Transformation(BigDecimal data) {

        if (data.compareTo(maxDouble) == 1) {
            this.result = "out of limits";
        }else{
            this.result = data.setScale(4, RoundingMode.HALF_UP);
            String resultString = this.result.toString();

            for (int i = 0; i<5; i++){
                if (resultString.endsWith("0") || resultString.endsWith(".")){
                    resultString = resultString.substring(0, resultString.length() - 1);
                }
            }
            this.result = resultString;
        }

    }

    public Object getResult() {
        return result;
    }
}
