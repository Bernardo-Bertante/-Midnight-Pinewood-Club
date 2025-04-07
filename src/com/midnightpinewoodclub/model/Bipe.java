package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.util.Title;

public class Bipe {

    private final int serialNumber;
    private Enum<Title> title;
    private final String issueDate;
    private boolean onMission;

    public Bipe(int serialNumber, Enum<Title> title, String issueDate, boolean onMission) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.issueDate = issueDate;
        this.onMission = onMission;
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

    public void setOnMission(boolean onMission) {
        this.onMission = onMission;
    }

}
