package com.midnightpinewoodclub.model.stories;

public class MainStory implements Story {
    private final int missionNumber;

    public MainStory(int missionNumber) {
        this.missionNumber = missionNumber;
    }

    @Override
    public String tellStory() {
        return switch (missionNumber) {
            case 0 -> "Em uma pequena vila, um grupo foi chamado. Eles não sabiam o motivo, mas sentiram: era um chamado do Alto. E decidiram atender.";
            case 1 -> "A missão deste ano é clara: levar amor onde há ódio, luz onde há trevas, e fé onde há desespero. E você foi escolhido para isso.";
            default -> "Desde o início dos tempos, houve uma promessa. Agora é hora de se levantar, pois chegou o tempo do despertar.";
        };
    }
}
