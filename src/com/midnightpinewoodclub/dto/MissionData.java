package com.midnightpinewoodclub.dto;

import com.midnightpinewoodclub.util.MissionType;

public class MissionData {
    public int id;
    public String title;
    public String description;
    public MissionType type;
    public RewardData reward;

    public static class RewardData {
        public String name;
        public String description;
        public String type;
    }
}
