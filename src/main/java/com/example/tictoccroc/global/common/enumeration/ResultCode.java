package com.example.tictoccroc.global.common.enumeration;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum ResultCode {

    // 성공
    SUCCESS(OK, "처리 되었습니다."),

    // 실패
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "처리에 실패했습니다."),
    VALUE_NOT_FOUND(NOT_FOUND, "데이터를 찾을 수 없습니다."),
    VALUE_BAD_REQUEST(BAD_REQUEST, "잘못된 요청입니다."),
    ALREADY_RESERVATION(BAD_REQUEST, "이미 예약한 수업입니다."),
    BAD_DATE(BAD_REQUEST, "예약은 다음 날 부터 이주 전까지 가능합니다."),
    OVER_COUNT(BAD_REQUEST, "예약 가능한 인원이 초과되었습니다.");

    private final HttpStatus status;
    private final String message;

    ResultCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
