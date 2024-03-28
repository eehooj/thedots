package com.example.tictoccroc.api.reservation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
public class ReservationResponse {

    @Schema(description = "예약 id", example = "1")
    private Long reservationId;

    @Schema(description = "수업", example = "2024-03-28 20:00:00")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lectureDt;

    @Schema(description = "예약 상태", example = "승인")
    private String status;

    @Schema(description = "수업 이름", example = "오감 놀이")
    private String lectureName;
}
