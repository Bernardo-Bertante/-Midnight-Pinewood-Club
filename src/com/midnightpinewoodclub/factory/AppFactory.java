package com.midnightpinewoodclub.factory;

import com.midnightpinewoodclub.controller.BipeController;
import com.midnightpinewoodclub.controller.MainController;
import com.midnightpinewoodclub.controller.MemberController;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.repository.MemberRepository;
import com.midnightpinewoodclub.service.IMemberService;
import com.midnightpinewoodclub.service.MemberService;

import java.util.Scanner;

public class AppFactory {
    public static final Scanner scanner = new Scanner(System.in);

    public static IMemberRepository createMemberRepository() {
        return MemberRepository.getInstance();
    }

    public static IMemberService createMemberService() {
        return new MemberService();
    }

    public static MemberController createMemberController() {
        return new MemberController(createMemberService(), scanner);
    }

    public static BipeController createBipeController() {
        return new BipeController(scanner);
    }




    public static MainController createMainController() {
        return new MainController(createMemberController(), createBipeController(), scanner);
    }

    public static void closeScanner() {
        scanner.close();
    }

}
