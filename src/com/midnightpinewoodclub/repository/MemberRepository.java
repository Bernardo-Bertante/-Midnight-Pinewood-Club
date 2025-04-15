package com.midnightpinewoodclub.repository;

import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.model.Member;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MemberRepository implements IMemberRepository{
    private final List<Member> members = new ArrayList<>();

    @Override
    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    @Override
    public void removeMember(Member member) {
        members.remove(member);
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public boolean serialNumberCheck(int serialNumber) {
        if (members.isEmpty()) {
            return false;
        }
        boolean validation;
        for (Member member : members) {
            validation = member.getBipe().getSerialNumber() == serialNumber;
            if (validation) {return true;}
        }
        return false;
    }

    @Override
    public Member getMemberByBipeCode(int serialNumber) {
        for (Member member: members) {
            if (member.getBipe().getSerialNumber() == serialNumber) {
                return member;
            }
        }
        return null;
    }


}
