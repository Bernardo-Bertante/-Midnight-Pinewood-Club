package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.service.IMissionService;
import com.midnightpinewoodclub.util.InputUtil;

public class MissionController implements IMissionController{
    private final IMissionService missionService;

    public MissionController(IMissionService missionService) {
        this.missionService = missionService;
    }

    @Override
    public void accessMission(boolean missionStatus, int serialCode) {
        while (true) {
            System.out.println(missionService.showCurrentOption(missionStatus, serialCode));

            int response = InputUtil.readInt("\nWhat do you want to do?");

            if (missionStatus) {

            } else {
                missionService.startMission(serialCode, response - 1);
            }

            switch (response) {
                case 1:
                    //showBipeInfos();
                    break;
                case 2:
                    //missionController.accessMission();
                    break;
                case 3:
                    //inventoryController.openInventory(serialCode);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("i should click in the buttons..");
            }
        }
    }

}
