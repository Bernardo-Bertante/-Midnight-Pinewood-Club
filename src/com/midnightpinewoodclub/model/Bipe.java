package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.model.missions.Mission;
import com.midnightpinewoodclub.util.Title;

public class Bipe {

    private final int serialNumber;
    private Enum<Title> title;
    private final String issueDate;
    private boolean onMission;
    private Mission mission;
    private int currentMissionId;

    public Bipe(int serialNumber, Enum<Title> title, String issueDate) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.issueDate = issueDate;
        this.onMission = false;
        this.mission = null;
        this.currentMissionId = 0;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public Enum<Title> getTitle() {
        return title;
    }

    public void setTitle(Enum<Title> title) {
        this.title = title;
    }

    public boolean isOnMission() {
        return onMission;
    }

    public int getCurrentMissionId() {
        return currentMissionId;
    }

    public Mission getMission() {return mission;}

    public void setOnMission(boolean onMission) {
        this.onMission = onMission;
    }

    public void setCurrentMission(Mission mission) {
        this.mission = mission;
        this.currentMissionId = mission.getId();
    }

}
