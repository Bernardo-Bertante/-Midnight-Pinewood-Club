package com.midnightpinewoodclub.service;

public interface IMissionService {
    String showCurrentOption(boolean missionStatus, int serialCode);

    String startMission(int serialCode, int missionIndex);
}
