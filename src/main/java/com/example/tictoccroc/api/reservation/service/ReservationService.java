package com.example.tictoccroc.api.reservation.service;

import com.example.tictoccroc.api.member.domain.entity.Member;
import com.example.tictoccroc.api.member.domain.service.MemberDomainService;
import com.example.tictoccroc.api.reservation.domain.entity.Reservation;
import com.example.tictoccroc.api.reservation.domain.entity.StoreLecture;
import com.example.tictoccroc.api.reservation.domain.service.ReservationDomainService;
import com.example.tictoccroc.api.reservation.dto.request.CreateReservationRequest;
import com.example.tictoccroc.api.reservation.dto.response.ReservationResponse;
import com.example.tictoccroc.global.exception.AlreadyReservationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.tictoccroc.global.common.enumeration.ResultCode.ALREADY_RESERVATION;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationDomainService reservationDomainService;
    private final MemberDomainService memberDomainService;

    public ReservationResponse createReservation(CreateReservationRequest reservationRequest) {
        Member member = memberDomainService.get(reservationRequest.getMemberId());
        StoreLecture storeLecture = reservationDomainService.get(reservationRequest.getStoreLectureId());

        // 이미 예약을 했던 사람인지 조회
        boolean isAlreadyReservation
                = reservationDomainService.isAlreadyReservation(
                        reservationRequest.getMemberId(), reservationRequest.getStoreLectureId());

        if (isAlreadyReservation) {
            throw new AlreadyReservationException(
                    ALREADY_RESERVATION.name(), ALREADY_RESERVATION.getMessage());
        } else {
            Reservation reservation = reservationDomainService
                    .create(Reservation.createReservation(storeLecture, member));

            return ReservationResponse
                    .builder()
                    .reservationId(reservation.getId())
                    .reservationDt(reservation.getReservationDt())
                    .status(reservation.getStatus().name())
                    .storeLectureName(reservation.getStoreLecture().getLecture().getName())
                    .build();
        }
    }
}
