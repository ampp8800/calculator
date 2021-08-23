package com.ampp8800.calculator;

public class MathematicalFunction {
    enum Procedure {
        SUM("+"),
        SUB("-"),
        MUL("*"),
        DIV("/"),
        FAC("!"),
        REM("remembr"),
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
                case "+":
                    return Procedure.SUM;
                case "-":
                    return Procedure.SUB;
                case "*":
                    return Procedure.MUL;
                case "/":
                    return Procedure.DIV;
                case "!":
                    return Procedure.FAC;
                case "remembr":
                    return Procedure.REM;
                case "show":
                    return Procedure.SHOW;
                case "exit":
                    return Procedure.EXIT;
                case "q":
                    return Procedure.EXIT;
                case "removeall":
                    return Procedure.DEL;
                case "help":
                    return Procedure.HELP;
                default:
                    return Procedure.ERROR;
            }

        }

    }
}
