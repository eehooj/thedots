package com.example.tictoccroc.api.reservation.service;

import com.example.tictoccroc.api.member.domain.entity.Member;
import com.example.tictoccroc.api.member.domain.service.MemberDomainService;
import com.example.tictoccroc.api.reservation.domain.entity.Reservation;
import com.example.tictoccroc.api.reservation.domain.entity.StoreLecture;
import com.example.tictoccroc.api.reservation.domain.service.ReservationDomainService;
import com.example.tictoccroc.api.reservation.dto.request.ReservationRequest;
import com.example.tictoccroc.api.reservation.dto.response.ReservationResponse;
import com.example.tictoccroc.global.exception.ReservationException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.example.tictoccroc.global.common.enumeration.ResultCode.*;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationDomainService reservationDomainService;
    private final MemberDomainService memberDomainService;

    /**
     *  예약 하기
     * @return ReservationResponse
     */
    @Transactional
    public ReservationResponse createReservation(ReservationRequest reservationRequest) {
        Member member = memberDomainService.get(reservationRequest.getMemberId());
        StoreLecture storeLecture = reservationDomainService.getStoreLecture(reservationRequest.getStoreLectureId());

        validCheck(reservationRequest, storeLecture);

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

    private void validCheck(ReservationRequest reservationRequest, StoreLecture storeLecture) {
        // 예약 날짜 확인
        LocalDate today = LocalDate.now();
        LocalDate lectureDate = storeLecture.getLectureDt().toLocalDate();

        if (lectureDate.isBefore(today)
                || lectureDate.isEqual(today)
                || lectureDate.isAfter(today.plusDays(14))) {
            throw new ReservationException(BAD_DATE.name(), BAD_DATE.getMessage());
        }

        // 최대 인원을 넘었는지 확인
        int count = reservationDomainService.countingReservation(reservationRequest.getStoreLectureId());

        if ((count + reservationRequest.getCount()) > storeLecture.getLecture().getMaxCount()) {
            throw new ReservationException(OVER_COUNT.name(), OVER_COUNT.getMessage());
        }

        // 이미 예약을 했던 사람인지 조회
        boolean isAlreadyReservation
                = reservationDomainService.isAlreadyReservation(
                reservationRequest.getMemberId(), reservationRequest.getStoreLectureId());

        if (isAlreadyReservation) {
            throw new ReservationException(
                    ALREADY_RESERVATION.name(), ALREADY_RESERVATION.getMessage());
        }
    }

    /**
     * 예약 취소
     * @return Long
     */
    @Transactional
    public Long cancelReservation(Long memberId, Long reservationId) throws BadRequestException {
        Reservation reservation = reservationDomainService.getReservation(reservationId);

        if (!reservation.getMember().getId().equals(memberId)) {
            throw new BadRequestException();
        }

        reservation.cancelReservation();

        return reservation.getId();
    }
}
