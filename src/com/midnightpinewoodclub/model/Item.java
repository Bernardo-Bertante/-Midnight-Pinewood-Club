package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.util.MissionType;

public class Item {
    private final String name;
    private final MissionType type;
    private final String description;


    public Item(String name, MissionType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public MissionType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

}
