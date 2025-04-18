package com.midnightpinewoodclub.model.stories;

public class ChristmasStory implements Story {
    private final int year;

    public ChristmasStory(int year) {
        this.year = year;
    }

    @Override
    public String tellStory() {
        return switch (year) {
            case 2023 -> "Em 2022, a neve caiu cedo, e algo mágico aconteceu na vila...";
            case 2024 -> "O Natal de 2023 trouxe consigo uma missão inesperada no topo do mundo!";
            case 2025 -> "No ano de 2024, os pinheiros guardavam um segredo sombrio...";
            default -> "É mais um Natal misterioso... algo está diferente este ano.";
        };
    }
}
