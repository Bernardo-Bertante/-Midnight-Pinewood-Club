package com.midnightpinewoodclub.repository;

import com.midnightpinewoodclub.model.missions.Mission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissionRepository implements IMissionRepository{
    private final List<Mission> missions = new ArrayList<>();

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(missions);
    }

    @Override
    public Mission getMission(int missionId) {
        for (Mission mission : missions) {
            if (mission.getId() == missionId){
                return mission;
            }
        }
        return null;
    }

    @Override
    public Mission getMissionByIndex(int missionIndex) {
        return missions.get(missionIndex);
    }

    @Override
    public void removeMission(Mission mission) {
        missions.remove(mission);
    }

    @Override
    public void addMission(Mission mission) {
        missions.add(mission);
    }
}
