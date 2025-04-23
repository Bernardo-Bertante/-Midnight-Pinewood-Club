package com.midnightpinewoodclub.repository;

import com.midnightpinewoodclub.model.missions.Mission;

import java.util.List;

public interface IMissionRepository {
    int getMissionsSize();

    List<Mission> getMissions();

    Mission getMission(int missionId);

    Mission getMissionByIndex(int missionIndex);

    void setMissions(List<Mission> missions);

    void removeMission(Mission mission);

    void addMission(Mission mission);
}
