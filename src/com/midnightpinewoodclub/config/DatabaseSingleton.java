package com.midnightpinewoodclub.config;

import com.midnightpinewoodclub.model.Member;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class DatabaseSingleton {

    private static volatile DatabaseSingleton instance;
    private List<Member> members;

    private DatabaseSingleton() {
        members = Collections.unmodifiableList(new ArrayList<>());
    }

    public static DatabaseSingleton getInstance() {
        DatabaseSingleton tempInstance = instance;
        if (tempInstance == null) {
            synchronized (DatabaseSingleton.class) {
                tempInstance = instance;
                if (tempInstance == null) {
                    instance = tempInstance = new DatabaseSingleton();
                }
            }
        }
        return instance;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMembers(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }
}
