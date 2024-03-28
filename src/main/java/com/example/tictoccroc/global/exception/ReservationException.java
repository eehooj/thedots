package com.example.tictoccroc.global.exception;

public class ReservationException extends RuntimeException {

    private final String code;

    private final String message;

    public ReservationException(String code, String message) {
        super(message);

        this.code = code;
        this.message = message;
    }
}
