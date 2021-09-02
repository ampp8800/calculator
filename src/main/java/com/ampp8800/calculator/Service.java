package com.ampp8800.calculator;


public class Service {

    public static String definition(Data data) {
        if (Operation.Command.REMEMBER.equals(data.getOp())) {
            return RepositoryWorker.recording(data.getStr());
        }
        if (Operation.Command.SHOW.equals(data.getOp())) {
            return RepositoryWorker.reading(data.getStr());
        }
        if (Operation.Command.EXIT.equals(data.getOp())) {
            return "close calculator";
        }
        if (Operation.Command.REMOVE_ALL.equals(data.getOp())) {
            RepositoryWorker.removeAll();
            return "repository clear";
        }
        if (Operation.Command.HELP.equals(data.getOp())) {
            UserStreamProcesson.help();
        }
        return null;
    }
}
