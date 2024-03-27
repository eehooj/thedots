package com.example.tictoccroc.api.reservation.domain.repository.custom;

public interface ReservationRepositoryCustom {

    boolean isAlreadyReservation(Long memberId, Long storeLectureId);
}
