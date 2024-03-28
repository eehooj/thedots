package com.example.tictoccroc.api.reservation.enumertion;

import static java.util.Arrays.stream;

public enum ReservationStatus {

    APPROVAL("승인"),
    CANCEL("취소");

    private final String value;

    ReservationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ReservationStatus find(String key) {
        return stream(ReservationStatus.values())
                .filter(item -> item.name().equalsIgnoreCase(key))
                .findAny()
                .orElse(null);
    }
}
