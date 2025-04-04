package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.util.Gender;

public class MemberService implements IMemberService{
    private final IMemberRepository memberRepository;
    private final BipeService bipeService;

    public MemberService(IMemberRepository memberRepository, BipeService bipeService) {
        this.memberRepository = memberRepository;
        this.bipeService = bipeService;
    }

    public void addMember(String name, int age, Gender gender) throws AgeRestrictionException {
            if (age < 10) {
                throw new AgeRestrictionException(age);
            }
            Member newMember = new Member(name, age, gender, bipeService.createBipe());
            memberRepository.addMember(newMember);

        //bipe validation if exist in BipeService
    }
}
