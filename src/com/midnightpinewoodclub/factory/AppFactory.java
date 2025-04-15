package com.midnightpinewoodclub.factory;

import com.midnightpinewoodclub.controller.BipeController;
import com.midnightpinewoodclub.controller.MainController;
import com.midnightpinewoodclub.controller.MemberController;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.repository.MemberRepository;
import com.midnightpinewoodclub.service.BipeService;
import com.midnightpinewoodclub.service.IBipeService;
import com.midnightpinewoodclub.service.IMemberService;
import com.midnightpinewoodclub.service.MemberService;

import java.util.Scanner;

public class AppFactory {
    public static final Scanner scanner = new Scanner(System.in);

    // SINGLE INSTANCES
    private static final IMemberRepository memberRepository = new MemberRepository(); // ou .getInstance()
    private static final IBipeService bipeService = new BipeService(memberRepository);
    private static final IMemberService memberService = new MemberService(memberRepository, bipeService);

    private static final MemberController memberController = new MemberController(memberService);
    private static final BipeController bipeController = new BipeController(bipeService, memberService);

    public static MemberController createMemberController() {
        return memberController;
    }

    public static BipeController createBipeController() {
        return bipeController;
    }

    public static MainController createMainController() {
        return new MainController(memberController, bipeController, scanner);
    }

    public static void closeScanner() {
        scanner.close();
    }
}

