package com.example.tictoccroc.api.reservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateReservationRequest {

    private Long memberId;

    private Long storeLectureId;
}
