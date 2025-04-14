package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Bipe;
import com.midnightpinewoodclub.model.Member;

public interface IBipeService {
    Bipe createBipe();
    Member getMemberByBipeCode(int serialNumber);
    String getBipeInfos(Member member);
}
