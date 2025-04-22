package com.midnightpinewoodclub.util;

import com.midnightpinewoodclub.model.missions.Mission;

import java.io.Reader;
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
                Item reward = new Item(data.reward.name, data.reward.description, ItemType.valueOf(data.reward.type));
                missions.add(MissionFactory.createMission(data.type, data.id, data.title, data.description, reward));
            }
            return missions;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar missões: " + e.getMessage());
        }
    }
}
