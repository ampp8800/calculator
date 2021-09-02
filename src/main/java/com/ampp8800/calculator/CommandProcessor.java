package com.ampp8800.calculator;

public class CommandProcessor {
    public static Data treatment(Data data) {
        if (Operation.CommandType.MATH.equals(data.getOp().getCommandType())) {
            return new Data(Math.definition(data), data.getOp());

        }
        if (Operation.CommandType.SERVICE.equals(data.getOp().getCommandType())) {
            return new Data(Service.definition(data), data.getOp());
        }
        return null;

    }
}
