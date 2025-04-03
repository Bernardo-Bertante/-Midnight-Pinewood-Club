package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.util.Title;

import java.util.Date;

public class Bipe {

    private final String serialNumber;
    private String codename;
    private Enum<Title> title;
    private final Date issueDate;
    private boolean onMission;

    public Bipe(String serialNumber, String codename, Enum<Title> title, Date issueDate, boolean onMission) {
        this.serialNumber = serialNumber;
        this.codename = codename;
        this.title = title;
        this.issueDate = issueDate;
        this.onMission = onMission;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
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
