package com.example.tictoccroc.api.reservation.dmain.entity;

import com.example.tictoccroc.api.member.dmain.entity.Member;
import com.example.tictoccroc.global.extension.EntityBaseExtension;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends EntityBaseExtension {

    @CreatedDate
    @Column(name = "RESERVATION_DT")
    protected LocalDateTime reservationDt;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "STORE_LECTURE_ID")
    private StoreLecture storeLecture;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
