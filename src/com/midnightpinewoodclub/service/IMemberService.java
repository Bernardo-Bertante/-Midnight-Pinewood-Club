package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.util.Gender;

public interface IMemberService {
    void addMember(String name, int age, Gender gender) throws AgeRestrictionException;

}
