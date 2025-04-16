package com.midnightpinewoodclub.model;

import com.midnightpinewoodclub.util.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private String name;
    private int age;
    private final Gender gender;
    private final Bipe bipe;
    private List<Item> inventory;

    public Member(String name, int age, Gender gender, Bipe bipe) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bipe = bipe;
        this.inventory = new ArrayList<>();
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventoryItems() {
        return Collections.unmodifiableList(inventory);
    }

}
