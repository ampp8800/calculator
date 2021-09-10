package com.ampp8800.calculator;

public class Service {

    public static Warehouse definition(Data data) {
        switch (data.getOp()) {
            case REMEMBER:
                if (data.getStr() != null) {
                    return new Warehouse(RepositoryWorker.recording(data.getStr()));
                }
            case SHOW:
                if (data.getStr() != null) {
                    return new Warehouse(RepositoryWorker.reading(data.getStr()));
                }
            case EXIT:
                if (data.getStr() == null) {
                    return new Warehouse("close calculator", true);
                }
            case REMOVE_ALL:
                if (data.getStr() == null) {
                    RepositoryWorker.removeAll();
                    return new Warehouse("repository clear");
                }
            case HELP:
                if (data.getStr() == null) {
                    UserStreamProcesson.help();
                    return new Warehouse();
                }
            default:
                return null;
        }
    }
}