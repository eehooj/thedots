package com.example.tictoccroc.api.reservation.dto.response;

import com.example.tictoccroc.api.reservation.enumertion.ReservationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "예약 id", example = "1")
    private Long reservationId;

    @Schema(description = "매장 이름", example = "판교점")
    private String storeName;

    @Schema(description = "수업 이름", example = "오감 놀이")
    private String lectureName;

    @Schema(description = "수업일", example = "2024-03-28 20:00:00")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lectureDt;

    @Schema(description = "예약 상태", example = "승인")
    private String status;

    @Schema(description = "예약 부모 이름", example = "이악어")
    private String memberName;

    @Schema(description = "예약일", example = "2024-03-25 23:02:03")
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

