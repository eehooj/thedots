package com.example.tictoccroc.api.reservation.domain.repository.custom;

import com.example.tictoccroc.api.reservation.domain.entity.Reservation;
import com.example.tictoccroc.api.reservation.dto.request.ReservationListRequest;
import com.example.tictoccroc.api.reservation.dto.response.QReservationListResponse;
import com.example.tictoccroc.api.reservation.dto.response.ReservationListResponse;
import com.example.tictoccroc.api.reservation.enumertion.ReservationStatus;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

import static com.example.tictoccroc.api.member.domain.entity.QMember.member;
import static com.example.tictoccroc.api.reservation.domain.entity.QLecture.lecture;
import static com.example.tictoccroc.api.reservation.domain.entity.QReservation.reservation;
import static com.example.tictoccroc.api.reservation.domain.entity.QStore.store;
import static com.example.tictoccroc.api.reservation.domain.entity.QStoreLecture.storeLecture;
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

    @Override
    public long countingReservation(Long storeLectureId) {
        return factory.selectFrom(reservation)
                .where(
                        reservation.storeLecture.id.eq(storeLectureId),
                        reservation.status.eq(APPROVAL)
                ).stream().count();
    }

    @Override
    public List<ReservationListResponse> reservationList(ReservationListRequest listRequest) {
        return factory.select(
                        new QReservationListResponse(
                                reservation.id,
                                store.name,
                                lecture.name,
                                storeLecture.lectureDt,
                                reservation.status,
                                member.name,
                                reservation.insertDt
                        ))
                .from(store)
                .innerJoin(storeLecture)
                .on(store.id.eq(storeLecture.store.id))
                .innerJoin(lecture)
                .on(storeLecture.lecture.id.eq(lecture.id))
                .innerJoin(reservation)
                .on(storeLecture.id.eq(reservation.storeLecture.id))
                .innerJoin(member)
                .on(reservation.member.id.eq(member.id))
                .where(
                        lectureSearch(listRequest.getLectureCode()),
                        storeSearch(listRequest.getStoreCode()),
                        statusSearch(listRequest.getStatus())
                )
                .fetch();
    }

    private BooleanExpression statusSearch(String status) {
        if (Objects.isNull(status)) {
            return null;
        }

        return reservation.status.eq(ReservationStatus.find(status));
    }

    private BooleanExpression storeSearch(String code) {
        if (Objects.isNull(code)) {
            return null;
        }

        return store.code.eq(code);
    }

    private BooleanExpression lectureSearch(String code) {
        if (Objects.isNull(code)) {
            return null;
        }

        return lecture.code.eq(code);
    }
}