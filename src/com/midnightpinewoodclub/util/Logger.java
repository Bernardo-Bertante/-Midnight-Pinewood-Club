package com.midnightpinewoodclub.util;

import com.midnightpinewoodclub.repository.MemberRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static volatile Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        Logger logger = instance;
        if (logger == null) {
            synchronized (Logger.class) {
                logger = instance;
                if (logger == null) {
                    logger = instance = new Logger();
                }
            }
        }
        return logger;
    }

    public void log(String message) {
        try(PrintWriter write = new PrintWriter(new FileWriter("Log.txt", true), true)) {
            write.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
