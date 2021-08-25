package com.ampp8800.calculator;

public class MathematicalFunction {
    private static final String SUM = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";
    private static final String FAC = "!";
    private static final String REM = "remeber";
    private static final String SHOW = "show";
    private static final String EXIT = "exit";
    private static final String ERROR = "error";
    private static final String DEL = "removeall";
    private static final String HELP = "help";
    enum Procedure {
        SUM(MathematicalFunction.SUM),
        SUB("-"),
        MUL("*"),
        DIV("/"),
        FAC("!"),
        REM("remember"),
        SHOW("show"),
        EXIT("exit"),
        ERROR("error"),
        DEL("removeall"),
        HELP("help");
        private String procedure;

        Procedure(String procedure) {
            this.procedure = procedure;
        }

        public String getProcedure() {
            return procedure;
        }

        static Procedure setProcedure(String procedure) {
            switch (procedure) {
                case MathematicalFunction.SUM:
                    return Procedure.SUM;
                case MathematicalFunction.SUB:
                    return Procedure.SUB;
                case MathematicalFunction.MUL:
                    return Procedure.MUL;
                case MathematicalFunction.DIV:
                    return Procedure.DIV;
                case MathematicalFunction.FAC:
                    return Procedure.FAC;
                case MathematicalFunction.REM:
                    return Procedure.REM;
                case MathematicalFunction.SHOW:
                    return Procedure.SHOW;
                case MathematicalFunction.EXIT:
                    return Procedure.EXIT;
                case "q":
                    return Procedure.EXIT;
                case MathematicalFunction.DEL:
                    return Procedure.DEL;
                case MathematicalFunction.HELP:
                    return Procedure.HELP;
                default:
                    return Procedure.ERROR;
            }

        }

    }
}
