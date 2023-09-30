package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    public void log(String message) {
        File file = new File("log.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
