package com.midnightpinewoodclub.factory;

import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.missions.Mission;
import com.midnightpinewoodclub.model.missions.ChristmasMission;
import com.midnightpinewoodclub.model.missions.HalloweenMission;
import com.midnightpinewoodclub.model.missions.EasterMission;
import com.midnightpinewoodclub.model.missions.SaintJohnMission;
import com.midnightpinewoodclub.model.missions.MainMission;

public class MissionFactory {
    public static Mission createMission(String type, int id, String title, String description, Item reward) {
        return switch (type.toUpperCase()) {
            case "CHRISTMAS" -> new ChristmasMission(id, title, description, reward);
            case "HALLOWEEN" -> new HalloweenMission(id, title, description, reward);
            case "EASTER" -> new EasterMission(id, title, description, reward);
            case "SAINTJOHN" -> new SaintJohnMission(id, title, description, reward);
            case "MAINSTORY" -> new MainMission(id, title, description, reward);
            default -> throw new IllegalArgumentException("Unknown mission type");
        };
    }
}
