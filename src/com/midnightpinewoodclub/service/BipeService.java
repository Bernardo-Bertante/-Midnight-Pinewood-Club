package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.util.Title;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BipeService {
    private final IMemberRepository memberRepository;

    public BipeService(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Bipe createBipe() {
        Random random = new Random();
        int value;
        do {
            value = random.nextInt(0, Integer.MAX_VALUE);
        } while (memberRepository.serialNumberCheck(value));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());

        return new Bipe(value, Title.values()[0], formattedDate, false);
    }

}
