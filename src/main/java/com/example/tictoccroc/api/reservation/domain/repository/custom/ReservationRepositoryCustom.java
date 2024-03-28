package com.example.tictoccroc.api.reservation.domain.repository.custom;

import com.example.tictoccroc.api.reservation.dto.request.ReservationListRequest;
import com.example.tictoccroc.api.reservation.dto.response.ReservationListResponse;

import java.util.List;

public interface ReservationRepositoryCustom {

    boolean isAlreadyReservation(Long memberId, Long storeLectureId);
    long countingReservation(Long storeLectureId);
    List<ReservationListResponse> reservationList(ReservationListRequest listRequest);
}
