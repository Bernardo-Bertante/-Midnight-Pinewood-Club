package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.exception.AgeRestrictionException;
import com.midnightpinewoodclub.service.IMemberService;
import com.midnightpinewoodclub.util.Gender;
import com.midnightpinewoodclub.util.InputUtil;

public class MemberController {
    private final IMemberService memberService;

    public MemberController(IMemberService memberService) {
        this.memberService = memberService;
    }

    public void registerMember() {
        while (true) {
            try {
                System.out.println("Please, tell me more about yourself:\n");
                String name = InputUtil.readString("Name: ");
                int age = InputUtil.readInt("Age: ");
                Gender gender = InputUtil.readEnum("Gender (MAN/WOMAN): ", Gender.class);

                memberService.addMember(name, age, gender);
                break;

            } catch (AgeRestrictionException e) {
                System.out.println(e.getMessage() + " Try again.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                break;
            }
        }
    }


}
