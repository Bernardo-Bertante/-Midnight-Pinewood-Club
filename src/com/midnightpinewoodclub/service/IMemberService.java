package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.util.Gender;
import com.midnightpinewoodclub.util.MemberEditRequest;

public interface IMemberService {
    Member addMember(String name, int age, Gender gender) throws AgeRestrictionException;
    Member getMemberByBipeCode(int serialNumber);
    String getBipeInfos(int serialCode);
    void changeMemberInfos(int serialCode, MemberEditRequest data);

}
