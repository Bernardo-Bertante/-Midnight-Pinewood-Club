package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.util.Gender;
import com.midnightpinewoodclub.util.Logger;

public class MemberService implements IMemberService{
    private final IMemberRepository memberRepository;
    private final BipeService bipeService;

    public MemberService(IMemberRepository memberRepository, BipeService bipeService) {
        this.memberRepository = memberRepository;
        this.bipeService = bipeService;
    }

    public Member addMember(String name, int age, Gender gender) throws AgeRestrictionException {
        if (age < 10) {
            if (age < 0) {age = 0;}
            throw new AgeRestrictionException(age);
        }
        Bipe newBipe = bipeService.createBipe();
        Member newMember = new Member(name, age, gender, newBipe);
        memberRepository.addMember(newMember);

        Logger.getInstance().log(String.format("Member %s with age %d, gender %s, and Bipe %s was created on %s.",
                name, age, gender.name(), newBipe.getSerialNumber(), newBipe.getIssueDate()));

        return newMember;
    }
}
