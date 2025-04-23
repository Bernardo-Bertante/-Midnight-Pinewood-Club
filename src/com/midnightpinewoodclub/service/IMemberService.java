package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.model.missions.Mission;
import com.midnightpinewoodclub.util.Gender;
import com.midnightpinewoodclub.dto.MemberEditRequest;

import java.util.List;

public interface IMemberService {
    Member addMember(String name, int age, Gender gender) throws AgeRestrictionException;
    Member getMemberByBipeCode(int serialNumber);
    String getBipeInfos(int serialCode);

    boolean getInMissionStatus(int serialCode);

    void changeMemberInfos(int serialCode, MemberEditRequest data);
    void addItem(int serialCode, Item item);
    List<Item> getInventory(int serialCode);
    String setMission(int serialCode, Mission mission);

    Mission getCurrentMission(int serialCode);
}
