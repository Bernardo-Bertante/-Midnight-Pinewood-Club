package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.repository.MemberRepository;

public class BipeService {
    private final IMemberRepository memberRepository;

    public BipeService(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Bipe createBipe() {
        Bipe newBipe = new Bipe()
        //bipe validation if exist in MemberRepository
    }
}
