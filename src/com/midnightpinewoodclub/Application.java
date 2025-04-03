package com.midnightpinewoodclub;

import com.midnightpinewoodclub.controller.MainController;
import com.midnightpinewoodclub.factory.AppFactory;

public class Application {
    public static void main(String[] args) {
        MainController mainController = AppFactory.createMainController();
        mainController.startMenu();
        AppFactory.closeScanner();
    }
}

