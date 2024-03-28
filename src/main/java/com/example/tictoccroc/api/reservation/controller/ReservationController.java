package com.example.tictoccroc.api.reservation.controller;

import com.example.tictoccroc.api.reservation.dto.request.ReservationListRequest;
import com.example.tictoccroc.api.reservation.dto.request.ReservationRequest;
import com.example.tictoccroc.api.reservation.dto.response.ReservationListResponse;
import com.example.tictoccroc.api.reservation.dto.response.ReservationResponse;
import com.example.tictoccroc.api.reservation.service.ReservationService;
import com.example.tictoccroc.global.common.dto.response.ResultResponse;
import com.example.tictoccroc.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.tictoccroc.global.util.URIUtil.RESERVATION;
import static com.example.tictoccroc.global.util.URIUtil.RESERVATION_ID;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(RESERVATION)
    public ResponseEntity<ResultResponse<ReservationResponse>> createReservation(
            @RequestBody ReservationRequest reservationRequest) {
        return ResponseUtil.ok(reservationService.createReservation(reservationRequest));
    }

    @PatchMapping(RESERVATION_ID)
    public ResponseEntity<ResultResponse<Long>> createReservation(
            @PathVariable Long reservationId, @RequestBody Long memberId) throws BadRequestException {
        return ResponseUtil.ok(reservationService.cancelReservation(memberId, reservationId));
    }

    @GetMapping(RESERVATION)
    public ResponseEntity<ResultResponse<List<ReservationListResponse>>> getReservationList(
            @ModelAttribute("listRequest") ReservationListRequest listRequest) {
        return ResponseUtil.ok(reservationService.reservationList(listRequest));
    }
}
