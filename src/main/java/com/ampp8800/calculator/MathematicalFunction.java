package com.ampp8800.calculator;

public class MathematicalFunction {
    enum Procedure {
        SUM("+"),
        SUB("-"),
        MUL("*"),
        DIV("/"),
        FAC("!"),
        EXIT("exit"),
        ERROR("error");
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
                case "exit":
                    return Procedure.EXIT;
                case "q":
                    return Procedure.EXIT;
                default:
                    return Procedure.ERROR;
            }

        }

    }
}
