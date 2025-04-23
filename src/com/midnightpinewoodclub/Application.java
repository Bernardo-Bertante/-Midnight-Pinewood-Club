package com.midnightpinewoodclub;

import com.midnightpinewoodclub.controller.MainController;
import com.midnightpinewoodclub.factory.AppFactory;
import com.midnightpinewoodclub.repository.IMissionRepository;
import com.midnightpinewoodclub.util.MissionLoader;

public class Application {
    public static void main(String[] args) {
        MainController mainController = AppFactory.createMainController();
        IMissionRepository missionRepository = AppFactory.createMissionRepository();
        missionRepository.setMissions(MissionLoader.loadMissions("/resources/mission.json"));
        mainController.startMenu();
        AppFactory.closeScanner();
    }
}

