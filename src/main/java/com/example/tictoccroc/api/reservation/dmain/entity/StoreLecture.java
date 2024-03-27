package com.example.tictoccroc.api.reservation.dmain.entity;

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
@Table(name = "STORE_LECTURE")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreLecture extends EntityBaseExtension {

    @CreatedDate
    @Column(name = "LECTURE_DT")
    protected LocalDateTime lectureDt;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;
}
