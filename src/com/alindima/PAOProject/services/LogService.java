package com.alindima.PAOProject.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LogService {
    private static LogService instance = new LogService();

    private static final String LOG_LOCATION = "C:\\Users\\alin\\IdeaProjects\\tickets\\logs\\log.txt";

    private static PrintWriter printWriter;

    public static LogService getInstance() {
        return instance;
    }

    private LogService() {
        try {
            printWriter = new PrintWriter(new FileOutputStream(new File(LOG_LOCATION),true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                closeWriter();
            }
        });
    }

    public void writeLine(String message) {
        LocalDateTime d = LocalDateTime.now();
        printWriter.println(message + "," + d);

    }

    private void closeWriter () {
        printWriter.flush();
        printWriter.close();
    }
}
