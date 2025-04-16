package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.util.Type;

public class Item {
    private final String name;
    private final Type type;
    private final String description;


    public Item(String name, Type type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
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
}
