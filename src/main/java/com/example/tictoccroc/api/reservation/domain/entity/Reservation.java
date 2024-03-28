package com.example.tictoccroc.api.reservation.domain.entity;

import com.example.tictoccroc.api.member.domain.entity.Member;
import com.example.tictoccroc.api.reservation.enumertion.ReservationStatus;
import com.example.tictoccroc.global.extension.EntityBaseExtension;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.example.tictoccroc.api.reservation.enumertion.ReservationStatus.APPROVAL;
import static com.example.tictoccroc.api.reservation.enumertion.ReservationStatus.CANCEL;

@Entity
@Table(name = "RESERVATION")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends EntityBaseExtension {

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "STORE_LECTURE_ID")
    private StoreLecture storeLecture;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private Reservation(StoreLecture storeLecture, Member member) {
        this.status = APPROVAL;
        this.storeLecture = storeLecture;
        this.member = member;
    }

    public static Reservation createReservation(StoreLecture storeLecture, Member member) {
        return new Reservation(storeLecture, member);
    }

    public void cancelReservation() {
        this.status = CANCEL;
    }
}
