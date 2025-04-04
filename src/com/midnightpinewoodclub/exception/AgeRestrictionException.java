package com.midnightpinewoodclub.exception;

import com.midnightpinewoodclub.util.Logger;

import java.util.List;
import java.util.Random;

public class AgeRestrictionException extends Exception {
    private final int age;
    private static final List<String> MESSAGES = List.of(
            "Access Denied: You're too young for the Midnight Pinewood Club!",
            "Oops! Only seasoned souls may enter the Midnight Pinewood Club.",
            "Forbidden: The Midnight Pinewood Club is not for the young and restless.",
            "You need more years under your belt to step into the Midnight Pinewood Club.",
            "Nice try, kid! The Midnight Pinewood Club is off-limits for now.",
            "You're not quite ripe for the Midnight Pinewood Club yet!",
            "Patience, young one. The Midnight Pinewood Club awaits... someday.",
            "No shortcuts to wisdom—come back when you're older!",
            "Age before entry: The Midnight Pinewood Club has its rules.",
            "Denied! The Midnight Pinewood Club is for those with a bit more... experience."
    );

    public AgeRestrictionException(int age) {
        this.age = age;
        loggerRegister();
    }

    private void loggerRegister() {
        Logger.getInstance().log(age +
                " tried to join the Club but received the fallowing message: " + getRandomMessage());
    }

    private String getRandomMessage() {
        Random random = new Random(age);
        return MESSAGES.get(random.nextInt(MESSAGES.size()));
    }

    @Override
    public String toString() {
        return getRandomMessage();
    }
}
