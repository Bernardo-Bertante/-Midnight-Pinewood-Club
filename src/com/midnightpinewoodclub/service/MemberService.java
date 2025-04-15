package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.util.Gender;
import com.midnightpinewoodclub.util.Logger;
import com.midnightpinewoodclub.util.MemberEditRequest;

public class MemberService implements IMemberService{
    private final IMemberRepository memberRepository;
    private final IBipeService bipeService;

    public MemberService(IMemberRepository memberRepository, IBipeService bipeService) {
        this.memberRepository = memberRepository;
        this.bipeService = bipeService;
    }

    @Override
    public Member addMember(String name, int age, Gender gender) throws AgeRestrictionException {
        if (age < 10) {
            if (age < 0) {age = 0;}
            throw new AgeRestrictionException(age);
        }
        Bipe newBipe = bipeService.createBipe();
        if (newBipe == null) {
            throw new IllegalStateException("Failed to create a new Bipe.");
        }
        Member newMember = new Member(name, age, gender, newBipe);
        memberRepository.addMember(newMember);

        Logger.getInstance().log(String.format("Member %s with age %d, gender %s, and Bipe %s was created on %s.",
                name, age, gender.name(), newBipe.getSerialNumber(), newBipe.getIssueDate()));

        return newMember;
    }

    @Override
    public Member getMemberByBipeCode(int serialCode) {
        return memberRepository.getMemberByBipeCode(serialCode);
    }

    @Override
    public String getBipeInfos(int serialCode) {
        Member member = getMemberByBipeCode(serialCode);
        if (member == null) {
            return "No Bipe found for the given serial number.";
        }
        Bipe bipe = member.getBipe();
        return String.format("Name: %s, Age: %d\nBipe Serial: %d, Issue Date: %s, Title: %s\n",
                member.getName(), member.getAge(), bipe.getSerialNumber(), bipe.getIssueDate(), bipe.getTitle());
    }

    @Override
    public void changeMemberInfos(int serialCode, MemberEditRequest newData) {
        Member member = getMemberByBipeCode(serialCode);
        member.setName(newData.getName());
        member.setAge(newData.getAge());
    }

}
