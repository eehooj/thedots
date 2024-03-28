package com.example.tictoccroc.api.reservation.dto.request;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ReservationListRequest {

    @Parameter(description = "매장 코드", example = "S003")
    private String storeCode;

    @Parameter(description = "수업 코드", example = "L002")
    private String lectureCode;

    @Parameter(description = "예약 상태 코드", example = "APPROVAL")
    private String status;
}
