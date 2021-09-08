package com.ampp8800.calculator;

public class Service {

    public static Warehouse definition(Data data) {
        if (Operation.Command.REMEMBER.equals(data.getOp())) {
            if (data.getStr() != null) {
                return new Warehouse(RepositoryWorker.recording(data.getStr()));
            }
        }
        if (Operation.Command.SHOW.equals(data.getOp())) {
            if (data.getStr() != null) {
                return new Warehouse(RepositoryWorker.reading(data.getStr()));
            }
        }
        if (Operation.Command.EXIT.equals(data.getOp())) {
            if (data.getStr() == null) {
                return new Warehouse("close calculator", true);
            }
        }
        if (Operation.Command.REMOVE_ALL.equals(data.getOp())) {
            if (data.getStr() == null) {
                RepositoryWorker.removeAll();
                return new Warehouse("repository clear");
            }
        }
        if (Operation.Command.HELP.equals(data.getOp())) {
            if (data.getStr() == null) {
                UserStreamProcesson.help();
                return new Warehouse();
            }
        }
        return null;
    }
}