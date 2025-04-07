package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.util.InputUtil;

import java.util.Scanner;

public class BipeController {
    private final Scanner input;

    public BipeController(Scanner scanner) {
        this.input = scanner;
    }

    public void accessBipe() {
        int serialCode = InputUtil.readInt();

        while (true) {
            System.out.println("");
        }
    }
}
