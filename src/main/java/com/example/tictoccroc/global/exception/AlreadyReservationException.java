package com.example.tictoccroc.global.exception;

public class AlreadyReservationException extends RuntimeException {

    private final String code;

    private final String message;

    public AlreadyReservationException(String code, String message) {
        super(message);

        this.code = code;
        this.message = message;
    }
}
