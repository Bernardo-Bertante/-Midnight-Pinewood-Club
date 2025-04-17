package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.util.Type;

public class Item {
    private final String name;
    private final Type type;
    private final String description;
    private final int id;

    public Item(String name, Type type, String description, int id) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
