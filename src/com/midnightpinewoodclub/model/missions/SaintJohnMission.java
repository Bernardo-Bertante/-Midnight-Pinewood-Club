package com.midnightpinewoodclub.model.missions;

import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.stories.SaintJohnStory;
import com.midnightpinewoodclub.model.stories.Story;

public class SaintJohnMission extends Mission {
    private final int year;

    public SaintJohnMission(int id, String title, String description, Item reward) {
        super(id, title, description, reward);
        this.year = id;
    }

    @Override
    public Story createStory() {
        return new SaintJohnStory(year);
    }
}
