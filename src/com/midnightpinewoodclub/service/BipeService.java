package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.util.Title;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BipeService implements IBipeService{
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

    public Bipe getBipeByCode(int serialCode) {
        return memberRepository.getMemberBipe(serialCode);
    }

    public String getBipeInfos(Bipe bipe) {
        if (bipe == null) {
            return "No Bipe found for the given serial number.";
        }
        return String.format("Bipe Serial: %d, Issue Date: %s, Title: %s\n",
                bipe.getSerialNumber(), bipe.getIssueDate(), bipe.getTitle());
    }

}
