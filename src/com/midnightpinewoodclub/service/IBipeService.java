package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Bipe;

public interface IBipeService {
    Bipe createBipe();
    Bipe getBipeByCode(int serialNumber);
    String getBipeInfos(Bipe bipe);
}
