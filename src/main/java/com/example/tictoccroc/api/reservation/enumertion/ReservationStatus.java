package com.example.tictoccroc.api.reservation.enumertion;

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
}
