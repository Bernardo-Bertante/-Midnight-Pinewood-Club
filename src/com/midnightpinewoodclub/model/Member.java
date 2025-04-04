package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.util.Gender;

public class Member {

    private final String name;
    private int age;
    private final Gender gender;
    private final Bipe bipe;

    public Member(String name, int age, Gender gender, Bipe bipe) {
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

    public Gender getGender() {
        return gender;
    }

    public Bipe getBipe() {
        return bipe;
    }
}
