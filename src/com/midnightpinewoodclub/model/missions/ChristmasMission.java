package com.midnightpinewoodclub.model.missions;

import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.stories.ChristmasStory;
import com.midnightpinewoodclub.model.stories.Story;

public class ChristmasMission extends Mission {

    public ChristmasMission(int id, String title, String description, Item reward) {
        super(id, title, description, reward);
    }

    @Override
    public Story createStory() {
        return new ChristmasStory();
    }
}
