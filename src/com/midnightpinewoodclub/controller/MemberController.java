package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.service.IMemberService;
import com.midnightpinewoodclub.service.MemberService;
import com.midnightpinewoodclub.util.Gender;
import com.midnightpinewoodclub.util.InputUtil;

public class MemberController {
    private final IMemberService memberService;

    public MemberController(IMemberService memberService) {
        this.memberService = memberService;
    }

    public void registerMember() {

            try {
                System.out.println("Please, tell me more about yourself:\n");
                String name = InputUtil.readString("Name: ");
                int age = InputUtil.readInt("Age: ");
                Gender gender = InputUtil.readEnum("Gender (MAN/WOMAN): ", Gender.class);

                Member member = memberService.addMember(name, age, gender);
                System.out.println("You are now part of the club! And your Bipe code is: " + member.getBipe().getSerialNumber() + "\n");


            } catch (AgeRestrictionException e) {
                System.out.println("\n" + e.getMessage() + " See you around kid!\n");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());

            }

    }


}
