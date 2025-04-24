package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.service.IBipeService;
import com.midnightpinewoodclub.service.IMemberService;
import com.midnightpinewoodclub.util.InputUtil;
import com.midnightpinewoodclub.dto.MemberEditRequest;

public class BipeController {
    private final IBipeService bipeService;
    private final IMemberService memberService;
    private final IInventoryController inventoryController;
    private IMissionController missionController;
    private int serialCode;

    public BipeController(IBipeService bipeService, IMemberService memberService, IInventoryController inventoryController, IMissionController missionController) {
        this.bipeService = bipeService;
        this.memberService = memberService;
        this.inventoryController = inventoryController;
        this.missionController = missionController;
    }

    public void accessBipe() {
        int serialCode = InputUtil.readInt("Password (SerialNumber):");
        System.out.println("starting..\n");
        if (memberService.getMemberByBipeCode(serialCode) == null) {
            System.out.println("Wrong Password!\n");
            return;
        }
        this.serialCode = serialCode;
        bipeMenu();
    }

    public void bipeMenu() {
        while (true) {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║   Your Midnight Pinewood Bipe    ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ [LCD]                            ║");
            System.out.printf("║  > Welcome, %s        ║\n", memberService.getMemberByBipeCode(serialCode).getBipe().getTitle());
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
                    missionController.accessMission(memberService.getInMissionStatus(serialCode), serialCode);
                    break;
                case 3:
                    inventoryController.openInventory(serialCode);
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
        while (true) {
            System.out.println(memberService.getBipeInfos(serialCode));
            System.out.println("[1] Edit Infos");
            System.out.println("[0] <--");

            int response = InputUtil.readInt("\nPress a button");

            switch (response) {
                case 1:
                    String novoNome = InputUtil.readString("New name: ");
                    int novaIdade = InputUtil.readInt("New age: ");
                    if (novaIdade < memberService.getMemberByBipeCode(serialCode).getAge()) {
                        throw new IllegalArgumentException("I don't think that how it works..New age cannot be lower than current age");
                    }
                    MemberEditRequest memberEditRequest = new MemberEditRequest(novoNome, novaIdade);
                    memberService.changeMemberInfos(serialCode, memberEditRequest);
                    System.out.println("Edit successfully made!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("i should click on an button..");
            }
        }

    }
}
