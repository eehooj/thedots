package com.example.tictoccroc.api.reservation.domain.repository.custom;

import com.example.tictoccroc.api.reservation.domain.entity.Reservation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

import static com.example.tictoccroc.api.reservation.domain.entity.QReservation.reservation;
import static com.example.tictoccroc.api.reservation.enumertion.ReservationStatus.APPROVAL;

@RequiredArgsConstructor
public class ReservationRepositoryCustomImpl implements ReservationRepositoryCustom {

    private final JPAQueryFactory factory;

    @Override
    public boolean isAlreadyReservation(Long memberId, Long storeLectureId) {
        Reservation query = factory.selectFrom(reservation)
                .where(
                        reservation.member.id.eq(memberId),
                        reservation.storeLecture.id.eq(storeLectureId),
                        reservation.status.eq(APPROVAL)
                ).fetchOne();

        return Objects.nonNull(query);
    }
}
