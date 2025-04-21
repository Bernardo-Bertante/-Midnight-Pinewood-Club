package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.missions.Mission;

public interface IMissionService {
    int getMissionsQuantity();

    String showCurrentOption(boolean missionStatus, int serialCode);

    Mission getMissionById(int missionId);

    String joinMission(int serialCode, int missionIndex);

    String startMissionStory(int serialCode);

    String finishMission(int serialCode);
}
