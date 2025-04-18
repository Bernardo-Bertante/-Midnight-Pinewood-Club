package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.util.MissionType;

public class Item {
    private final String name;
    private final MissionType type;
    private final String description;
    private final int id;

    public Item(String name, MissionType type, String description, int id) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.id = id;
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

    public int getId() {
        return id;
    }
}
