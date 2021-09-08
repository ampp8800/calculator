package com.ampp8800.calculator;

import java.math.BigDecimal;
import java.util.HashMap;

public class RepositoryWorker {

    static String recording(String strData) {
        if (Calculator.warehouse.getResultBD() != null) {
            try {
                Double.parseDouble(strData);
                return "You cannot use numbers for the cell name";
            } catch (Exception unused) {
                if (strData.lastIndexOf('!') != (strData.length() - 1)) {
                    Repository.setCell(strData, Calculator.warehouse.getResultBD());
                    return ("Add new cell " + reading(strData));

                } else {
                    return "You cannot use an exclamation mark at the end of a cell name";
                }
            }
        }
        return "No data to remember";
    }

    static String reading(String string) {
        if (Repository.getCell(string) != null) {
            return (string + ": " + Repository.getCell(string).toPlainString());
        }
        return "Cell not found";

    }

    static BigDecimal appropriation(String string) {
        BigDecimal bigDecimal;
        if (Repository.getCell(string) == null) {
            try {
                bigDecimal = new BigDecimal(string);
            } catch (Exception e) {
                bigDecimal = null;
            }
        } else {
            bigDecimal = Repository.getCell(string);
        }
        return bigDecimal;
    }

    public static void setCell(String string, BigDecimal bigDecimal) {
        Repository.setCell(string, bigDecimal);
    }

    public static HashMap<String, BigDecimal> getRepository() {
        return Repository.getRepository();
    }

    public static void removeAll() {
        Repository.removeRepository();
    }
}