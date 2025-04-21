package com.midnightpinewoodclub.model.stories;

public class SaintJohnStory implements Story {
    private final int year;

    public SaintJohnStory(int year) {
        this.year = year;
    }

    @Override
    public String tellStory() {
        return switch (year) {
            case 2024 -> "Nas margens do Jordão, uma voz clamava no deserto: 'Preparem o caminho do Senhor'. Era João, anunciando o Reino que viria.";
            case 2025 -> "Em 2024, muitos se reuniram para ouvir aquele que comia gafanhotos e mel. Sua mensagem? Arrependam-se, pois o Reino está próximo.";
            default -> "A festa de São João relembra o profeta que preparou os corações para receber o Salvador. Uma fogueira acesa não para festa, mas como farol de esperança.";
        };
    }

    private
}
