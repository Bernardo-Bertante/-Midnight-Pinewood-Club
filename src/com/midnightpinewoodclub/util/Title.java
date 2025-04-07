package com.midnightpinewoodclub.util;

public enum Title {
    SIGNAL_SEEKER(0),
    WAVE_WHISPERER(1),
    ECHO_CHASER(2),
    NIGHT_BROADCASTER(3),
    SILENT_OPERATOR(4),
    FREQUENCY_KEEPER(5),
    MIDNIGHT_OVERSEER(6);

    private final int value;

    Title(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
