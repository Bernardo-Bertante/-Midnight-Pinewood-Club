package com.midnightpinewoodclub.model.missions;

import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.stories.Story;

public abstract class Mission {
    private final int id;
    private final String title;
    private final String description;
    private final Item reward;

    public Mission(int id, String title, String description, Item reward) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.reward = reward;
    }

    public Item getReward() {
        return reward;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public Story joinMission(){
        Story story = createStory();
        story.tellStory();
        return story;
    }

    public abstract Story createStory();
}
