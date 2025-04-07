package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.util.Gender;

public interface IMemberService {
    Member addMember(String name, int age, Gender gender) throws AgeRestrictionException;

}
