package com.midnightpinewoodclub.repository;

import com.midnightpinewoodclub.model.missions.Mission;

import java.util.List;

public interface IMissionRepository {
    List<Mission> getMissions();

    Mission getMission(int missionId);

    Mission getMissionByIndex(int missionIndex);

    void removeMission(Mission mission);

    void addMission(Mission mission);
}
