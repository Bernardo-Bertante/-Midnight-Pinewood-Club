package com.midnightpinewoodclub.model.missions;

import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.stories.MainStory;
import com.midnightpinewoodclub.model.stories.Story;

public class MainMission extends Mission {
    public MainMission(int id, String title, String description, Item reward) {
        super(id, title, description, reward);
    }

    @Override
    public Story createStory() {
        return new MainStory();
    }
}
