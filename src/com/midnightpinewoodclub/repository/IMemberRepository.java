package com.midnightpinewoodclub.repository;

import com.midnightpinewoodclub.model.Member;

import java.util.List;

public interface IMemberRepository {
    List<Member> getMembers();
    void addMember(Member member);
    void removeMember(Member member);
}
