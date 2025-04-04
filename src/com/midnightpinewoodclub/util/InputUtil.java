package com.midnightpinewoodclub.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String message) {
        int value;
        while (true) {
            try {
                System.out.println(message);
                value = scanner.nextInt();
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static String readString(String message) {
        String value;
        while (true) {
            System.out.println(message);
            value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            } else {
                System.out.println("Input cannot be empty! Please try again.");
            }
        }
    }

    public static <T extends Enum<T>> T readEnum(String message, Class<T> enumType) {
        while (true) {
            try {
                System.out.println(message);
                String value = scanner.next().trim().toUpperCase();
                return Enum.valueOf(enumType, value);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option! Please enter a valid value: " + getEnumOptions(enumType));
            }
        }
    }

    private static <T extends Enum<T>> String getEnumOptions(Class<T> enumType) {
        StringBuilder options = new StringBuilder();
        for (T value : enumType.getEnumConstants()) {
            options.append(value.name()).append("\n");
        }
        return options.toString().trim();
    }
}
