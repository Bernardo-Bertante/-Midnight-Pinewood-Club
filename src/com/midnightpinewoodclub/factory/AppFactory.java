package com.midnightpinewoodclub.factory;

import com.midnightpinewoodclub.controller.*;
import com.midnightpinewoodclub.repository.IMemberRepository;
import com.midnightpinewoodclub.repository.MemberRepository;
import com.midnightpinewoodclub.service.*;

import java.util.Scanner;

public class AppFactory {
    public static final Scanner scanner = new Scanner(System.in);

    // SINGLE INSTANCES
    private static final IMemberRepository memberRepository = new MemberRepository();
    private static final IBipeService bipeService = new BipeService(memberRepository);
    private static final IMemberService memberService = new MemberService(memberRepository, bipeService);

    private static final IInventoryService inventoryService = new InventoryService(memberService);
    private static final IInventoryController inventoryController = new InventoryController(inventoryService);
    private static final MemberController memberController = new MemberController(memberService);
    private static final BipeController bipeController = new BipeController(bipeService, memberService, inventoryController);

    public static MemberController createMemberController() {
        return memberController;
    }

    public static BipeController createBipeController() {
        return bipeController;
    }

    public static IInventoryController createInventoryController() {
        return inventoryController;
    }

    public static MainController createMainController() {
        return new MainController(memberController, bipeController, scanner);
    }

    public static void closeScanner() {
        scanner.close();
    }
}

