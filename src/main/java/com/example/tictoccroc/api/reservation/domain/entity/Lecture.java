package com.example.tictoccroc.api.reservation.domain.entity;

import com.example.tictoccroc.global.extension.EntityBaseExtension;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "LECTURE")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture extends EntityBaseExtension {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "MAX_COUNT", nullable = false)
    private String maxCount;

}
