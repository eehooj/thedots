package com.example.tictoccroc.global.aop.domain.entity;

import com.example.tictoccroc.global.extension.EntityBaseExtension;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "ERROR_LOG")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorLog extends EntityBaseExtension {

    @Column(name = "URI", nullable = false)
    private String uri;

    @Lob
    @Column(name = "MESSAGE", nullable = false)
    private String message;
}
