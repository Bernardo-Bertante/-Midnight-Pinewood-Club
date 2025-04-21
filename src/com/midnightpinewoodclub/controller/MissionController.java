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
            int response;

            if (missionStatus) {
                System.out.println("\n[1] Joy the Story");
                System.out.println("[0] <--");
                response = InputUtil.readInt("\nWhat do you want to do?");
                switch (response) {
                    case 1:
                        missionService.startMissionStory(serialCode);
                        missionService.finishMission(serialCode);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("i should click in the buttons..");
                }

            } else {
                response = InputUtil.readIntInRange("\nChoose a mission: ", 1, missionService.getMissionsQuantity());
                System.out.println(missionService.joinMission(serialCode, response - 1));
                accessMission(true, serialCode);
            }


        }
    }

}
