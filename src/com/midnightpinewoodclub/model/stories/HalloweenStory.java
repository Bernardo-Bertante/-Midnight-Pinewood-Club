package com.midnightpinewoodclub.model.stories;

public class HalloweenStory implements Story {
    private final int year;

    public HalloweenStory(int year) {
        this.year = year;
    }

    @Override
    public String tellStory() {
        return switch (year) {
            case 2023 -> "Na noite escura, o jovem missionário caminhou com sua lanterna, proclamando que a luz de Cristo brilha mesmo nos vales mais sombrios.";
            case 2024 -> "Em um vilarejo cercado de medos, uma única vela acesa em nome de Jesus expulsou todo o terror. Pois o amor lança fora todo o medo.";
            default -> "O Halloween pode lembrar sombras, mas também revela que nenhum vale é profundo demais para a graça de Deus alcançar.";
        };
    }
}
