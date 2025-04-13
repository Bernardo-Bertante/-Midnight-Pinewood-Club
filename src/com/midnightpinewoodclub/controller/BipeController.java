package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.service.IBipeService;
import com.midnightpinewoodclub.util.InputUtil;

public class BipeController {
    private final IBipeService bipeService;
    private Bipe bipe;

    public BipeController(IBipeService bipeService) {
        this.bipeService = bipeService;
    }

    public void accessBipe() {
        int serialCode = InputUtil.readInt("Password (SerialNumber):");
        System.out.println("starting..\n");
        this.bipe = bipeService.getBipeByCode(serialCode);
        if (this.bipe == null) {
            System.out.println("Wrong Password!");
            return;
        }
        bipeMenu();
    }

    public void bipeMenu() {
        while (true) {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║   Your Midnight Pinewood Bipe    ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ [LCD]                            ║");
            System.out.printf("║  > Welcome, %s.       ║\n", bipe.getTitle());
            System.out.println("║  > Your mission awaits...        ║");
            System.out.println("║                                  ║");
            System.out.println("║  Choose an option:               ║");
            System.out.println("║                                  ║");
            System.out.println("║  [1] Display Infos               ║");
            System.out.println("║  [2] Missions                    ║");
            System.out.println("║  [3] My Backpack                 ║");
            System.out.println("║  [0] Exit Bipe                   ║");
            System.out.println("╚══════════════════════════════════╝");

            int response = InputUtil.readInt("\nWhat do you want to do?");

            switch (response) {
                case 1:
                    showBipeInfos();
                    break;
                case 2:
                    //bipeController.accessBipe();
                    break;
                case 3:
                    //bipeController.accessBipe();
                    break;
                case 0:
                    System.out.println("turning off..\n");
                    return;
                default:
                    System.out.println("i should click in the buttons..");
            }
        }
    }

    public void showBipeInfos() {
        System.out.println(bipeService.getBipeInfos(bipe));
    }
}
