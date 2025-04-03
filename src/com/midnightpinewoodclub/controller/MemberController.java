package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.service.IMemberService;
import com.midnightpinewoodclub.service.MemberService;
import com.midnightpinewoodclub.util.Gender;

import java.util.Scanner;

public class MemberController {
    private final IMemberService memberService;
    private final Scanner input;

    public MemberController(IMemberService memberService, Scanner scanner) {
        this.memberService = memberService;
        this.input = scanner;
    }

    public void registerMember() {
        String name;
        int age;
        Gender gender;

        System.out.println("Please, tell me more about yourself:\n");
        System.out.println("Name: ");
        name = input.next();

        System.out.println("Age: ");
        age = input.nextInt();
        input.nextLine();

        System.out.println("Gender (MAN/WOMAN): ");
        gender = Gender.valueOf(input.next().toUpperCase());

        MemberService memberService = new MemberService();
        memberService.addMember(name, age, gender);
    }

}
