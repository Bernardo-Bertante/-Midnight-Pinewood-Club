package com.midnightpinewoodclub.model;

public abstract class Member {

    private final String name;
    private int age;
    private final String gender;
    private final Bipe bipe;

    public Member(String name, int age, String gender, Bipe bipe) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bipe = bipe;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Bipe getBipe() {
        return bipe;
    }
}
