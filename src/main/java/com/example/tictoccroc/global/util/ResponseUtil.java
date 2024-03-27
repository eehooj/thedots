package com.example.tictoccroc.global.util;


import com.example.tictoccroc.global.common.dto.response.ResultResponse;
import com.example.tictoccroc.global.common.enumeration.ResultCode;
import lombok.experimental.UtilityClass;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import static com.example.tictoccroc.global.common.enumeration.ResultCode.SUCCESS;

@UtilityClass
public class ResponseUtil {

    public static <T> ResponseEntity<ResultResponse<T>> ok() {
        return ResponseEntity.ok(
                new ResultResponse<>(
                        SUCCESS.name(),
                        SUCCESS.getMessage(),
                        null));
    }

    public static <T> ResponseEntity<ResultResponse<T>> ok(T data) {
        return ResponseEntity.ok(
                new ResultResponse<>(
                        SUCCESS.name(),
                        SUCCESS.getMessage(),
                        data));
    }

    public static <T> ResponseEntity<ResultResponse<T>> ok(T data, ResultCode resultCode) {
        return ResponseEntity.ok(
                new ResultResponse<>(
                        resultCode.name(),
                        resultCode.getMessage(),
                        data));
    }

    public static ResponseEntity<ResultResponse<ProblemDetail>> error(ProblemDetail problemDetail) {
        return ResponseEntity.status(problemDetail.getStatus())
                .body(
                        new ResultResponse<>(
                                problemDetail.getTitle(), problemDetail.getDetail(), problemDetail));
    }
}
