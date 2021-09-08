package com.ampp8800.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Map;

class FileWorker {
    static void readFile() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("Repository.txt"))) {
            System.out.println("File uploaded " + new java.io.File("Repository.txt").getAbsolutePath());
            while (true) {
                String line[] = fileReader.readLine().split("=");
                BigDecimal bigDecimal = new BigDecimal(line[1]);
                RepositoryWorker.setCell(line[0], bigDecimal);
            }
        } catch (Exception unused) {
        }

    }

    static void writeFile() {
        try (FileWriter writer = new FileWriter("Repository.txt", false)) {
            for (Map.Entry<String, BigDecimal> entry : RepositoryWorker.getRepository().entrySet()) {
                writer.write(entry + "\n");

            }
            System.out.println("File recorded " + new java.io.File("Repository.txt").getAbsolutePath());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}