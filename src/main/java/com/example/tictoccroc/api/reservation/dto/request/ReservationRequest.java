package com.example.tictoccroc.api.reservation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    @Schema(description = "부모 id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long memberId;

    @Schema(description = "매장수업 id", example = "4", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long storeLectureId;

    @Schema(description = "인원수", example = "3", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "1")
    private Integer count;
}
