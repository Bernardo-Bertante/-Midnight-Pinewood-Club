package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.util.InputUtil;

import java.nio.file.LinkPermission;
import java.util.Scanner;

public class MainController {
    private final Scanner input;
    private final MemberController memberController;
    private final BipeController bipeController;

    public MainController(MemberController memberController, BipeController bipeController, Scanner scanner) {
        this.input = scanner;
        this.memberController = memberController;
        this.bipeController = bipeController;
    }

    public void startMenu() {
        System.out.println("\nWelcome to the Club - good to see you here!\n");
        while (true) {
            System.out.println("1. Join the Club");
            System.out.println("2. Your Bipe");
            System.out.println("0. See yah!");

            int response = InputUtil.readInt("\nWhat do you want to do?");

            switch (response) {
                case 1:
                    System.out.println("\nNice to hear that!");
                    memberController.registerMember();
                    break;
                case 2:
                    bipeController.accessBipe();
                    break;
                case 0:
                    System.out.println("till another midnight!");
                    input.close();
                    return;
                default:
                    System.out.println("i don't know what you're talking about..");
            }
        }
    }
}
