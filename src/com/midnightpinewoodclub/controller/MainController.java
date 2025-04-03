package com.midnightpinewoodclub.controller;

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
        while (true) {
            System.out.println("\nWelcome to the Club - good to see you here!\n");
            System.out.println("1. Join the Club");
            System.out.println("2. Your Bipe");
            System.out.println("0. See yah!");
            System.out.println("\nWhat do you want to do?\n");

            int response = input.nextInt();

            switch (response) {
                case 1:
                    System.out.println("Nice to hear that! Take this:");
                    memberController.registerMember();
                    break;
                case 2:
                    System.out.println("starting..\n");
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
