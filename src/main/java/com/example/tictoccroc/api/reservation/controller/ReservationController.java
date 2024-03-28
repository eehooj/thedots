package com.example.tictoccroc.api.reservation.controller;

import com.example.tictoccroc.api.reservation.dto.request.ReservationListRequest;
import com.example.tictoccroc.api.reservation.dto.request.ReservationRequest;
import com.example.tictoccroc.api.reservation.dto.response.ReservationListResponse;
import com.example.tictoccroc.api.reservation.dto.response.ReservationResponse;
import com.example.tictoccroc.api.reservation.service.ReservationService;
import com.example.tictoccroc.global.common.dto.response.ResultResponse;
import com.example.tictoccroc.global.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.tictoccroc.global.util.URIUtil.RESERVATION;
import static com.example.tictoccroc.global.util.URIUtil.RESERVATION_ID;

@Tag(name = "예약 API", description = "예약과 관련된 api")
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @Operation(summary = "예약하기")
    @PostMapping(RESERVATION)
    public ResponseEntity<ResultResponse<ReservationResponse>> createReservation(
            @RequestBody ReservationRequest reservationRequest) {
        return ResponseUtil.ok(reservationService.createReservation(reservationRequest));
    }

    @Operation(summary = "예약 취소하기")
    @PatchMapping(RESERVATION_ID)
    public ResponseEntity<ResultResponse<Long>> cancelReservation(
            @PathVariable Long reservationId, @RequestBody Long memberId) throws BadRequestException {
        return ResponseUtil.ok(reservationService.cancelReservation(memberId, reservationId));
    }

    @Operation(summary = "예약 목록(List) 조회",
            description =
                    """
                    | code | name |
                    |------|------|
                    | S001 | 잠실점 |
                    | S002 | 일산점 |
                    | S003 | 판교점 |
                    | - | - |
                    | L001 | 도시농부 |
                    | L002 | 드로잉 |
                    | L003 | 오감 놀이 |
                    ### 매장별 목록 조회하기
                    - storeCode 매장 코드 삽입
                    - 전체 매장 목록을 조회할 경우에는 storeCode 비워서 보내기
                    ### 수업별 목록 조회하기
                    - lectureCode 수업 코드 삽입
                    - 전체 수업 목록을 조회할 경우에는 lectureCode 비워서 보내기
                    ### 참고사항
                    - 매장, 수업 코드 조회 api는 추후 개발 예정
                    - 예약자 조회시 status 에 APPROVAL 삽입
                    - 모든 예약 이력 조회시 status 비워서 보내기
                    """)
    @GetMapping(RESERVATION)
    public ResponseEntity<ResultResponse<List<ReservationListResponse>>> getReservationList(
            @ParameterObject @ModelAttribute("listRequest") ReservationListRequest listRequest) {
        return ResponseUtil.ok(reservationService.reservationList(listRequest));
    }
}
