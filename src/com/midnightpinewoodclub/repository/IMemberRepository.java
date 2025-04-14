package com.midnightpinewoodclub.repository;

import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.model.Member;

import java.util.List;

public interface IMemberRepository {
    List<Member> getMembers();
    void addMember(Member member);
    void removeMember(Member member);
    boolean serialNumberCheck(int serialNumber);
    Member getMemberByBipeCode(int serialNumber);
}
