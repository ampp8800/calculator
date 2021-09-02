package com.ampp8800.calculator;


public class Operation {
    private static final String SUM = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String FACTORIAL = "!";

    private static final String REMEMBER = "remember";
    private static final String SHOW = "show";
    private static final String EXIT = "exit";
    private static final String REMOVE_ALL = "removeall";
    private static final String HELP = "help";

    enum CommandType {
        MATH,
        SERVICE
    }

    enum Command {
        SUM(CommandType.MATH, Operation.SUM),
        SUBTRACTION(CommandType.MATH, Operation.SUBTRACTION),
        MULTIPLICATION(CommandType.MATH, Operation.MULTIPLICATION),
        DIVISION(CommandType.MATH, Operation.DIVISION),
        FACTORIAL(CommandType.MATH, Operation.FACTORIAL),

        REMEMBER(CommandType.SERVICE, Operation.REMEMBER),
        SHOW(CommandType.SERVICE, Operation.SHOW),
        EXIT(CommandType.SERVICE, Operation.EXIT),
        REMOVE_ALL(CommandType.SERVICE, Operation.REMOVE_ALL),
        HELP(CommandType.SERVICE, Operation.HELP);

        private String operation;
        private CommandType commandType;

        Command(CommandType commandType, String operation) {
            this.operation = operation;
            this.commandType = commandType;
        }

        public String getOperation() {
            return operation;
        }

        public CommandType getCommandType() {
            return commandType;
        }

        public static Command getFromString(String stringCommand) {
            for (Command command : Command.values()) {
                if (command.getOperation().equalsIgnoreCase(stringCommand)) {
                    return command;
                }
            }
            return null;
        }

    }
}
