package com.midnightpinewoodclub.dto;

public class MemberEditRequest {
    private String name;
    private int age;

    public MemberEditRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MemberEditRequest() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
