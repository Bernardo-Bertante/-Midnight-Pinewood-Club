package com.midnightpinewoodclub.model.stories;

public class EasterStory implements Story {
    private final int year;

    public EasterStory(int year) {
        this.year = year;
    }

    @Override
    public String tellStory() {
        return switch (year) {
            case 2023 -> "Na manhã do terceiro dia, a pedra foi removida. O túmulo estava vazio, e com isso, a esperança renasceu.";
            case 2024 -> "Em 2024, os discípulos caminharam a caminho de Emaús, e no partir do pão reconheceram Aquele que venceu a morte.";
            default -> "A Páscoa nos lembra que a luz sempre vence a escuridão. Ele vive, ontem, hoje e para sempre.";
        };
    }
}
