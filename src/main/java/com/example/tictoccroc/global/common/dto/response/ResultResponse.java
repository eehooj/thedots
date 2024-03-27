package com.example.tictoccroc.global.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResultResponse<T> {

    private String code;

    private String message;

    private T data;
}
