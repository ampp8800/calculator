package com.ampp8800.calculator;

public class CommandProcessor {
    public static Warehouse treatment(Data data) {
        if (data != null) {
            if (data.getOp() != null) {
                if (Operation.CommandType.MATH.equals(data.getOp().getCommandType())) {
                    return new Warehouse(MathCommandProcessor.definition(data));
                }
                if (Operation.CommandType.SERVICE.equals(data.getOp().getCommandType())) {
                    return Service.definition(data);
                }
            }
        }
        return null;
    }
}