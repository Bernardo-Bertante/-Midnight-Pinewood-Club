package com.midnightpinewoodclub.util;

import com.midnightpinewoodclub.dto.MissionData;
import com.midnightpinewoodclub.factory.MissionFactory;
import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.missions.Mission;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MissionLoader {
    public static List<Mission> loadMissions(String path) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(path);
            Type missionListType = new TypeToken<List<MissionData>>(){}.getType();
            List<MissionData> missionDataList = gson.fromJson(reader, missionListType);

            List<Mission> missions = new ArrayList<>();
            for (MissionData data : missionDataList) {
                Item reward = new Item(data.reward.name, MissionType.valueOf(data.reward.type), data.reward.description);
                missions.add(MissionFactory.createMission(data.type, data.id, data.title, data.description, reward));
            }
            return missions;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar missões: " + e.getMessage());
        }
    }
}
