package com.example.tictoccroc.api.reservation.dto.request;

import com.example.tictoccroc.api.reservation.enumertion.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ReservationListRequest {

    private String storeCode;
    private String lectureCode;
    private ReservationStatus status;
}
