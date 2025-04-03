package com.midnightpinewoodclub.repository;

import com.midnightpinewoodclub.model.Member;

import java.util.List;
import java.util.ArrayList;

public class MemberRepository implements IMemberRepository{

    private static volatile MemberRepository instance;
    private final List<Member> members;

    private MemberRepository() {
        members = new ArrayList<>();
    }

    public static MemberRepository getInstance() {
        MemberRepository tempInstance = instance;
        if (tempInstance == null) {
            synchronized (MemberRepository.class) {
                tempInstance = instance;
                if (tempInstance == null) {
                    instance = tempInstance = new MemberRepository();
                }
            }
        }
        return tempInstance;
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
