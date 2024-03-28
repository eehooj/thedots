package com.example.tictoccroc.api.reservation.dto.response;

import com.example.tictoccroc.api.reservation.enumertion.ReservationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ReservationListResponse {

    private Long reservationId;

    private String storeName;

    private String lectureName;

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lectureDt;

    private String status;

    private String memberName;

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime reservationDt;

    @QueryProjection
    public ReservationListResponse(Long reservationId, String storeName, String lectureName, LocalDateTime lectureDt,
                                   ReservationStatus status, String memberName, LocalDateTime reservationDt) {
        this.reservationId = reservationId;
        this.storeName = storeName;
        this.lectureName = lectureName;
        this.lectureDt = lectureDt;
        this.status = status.getValue();
        this.memberName = memberName;
        this.reservationDt = reservationDt;
    }

}

