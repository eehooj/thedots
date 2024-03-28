package com.example.tictoccroc.api.reservation.controller;

import com.example.tictoccroc.api.reservation.dto.request.ReservationRequest;
import com.example.tictoccroc.api.reservation.dto.response.ReservationResponse;
import com.example.tictoccroc.api.reservation.service.ReservationService;
import com.example.tictoccroc.global.common.dto.response.ResultResponse;
import com.example.tictoccroc.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.tictoccroc.global.util.URIUtil.RESEVATION;
import static com.example.tictoccroc.global.util.URIUtil.RESEVATION_ID;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(RESEVATION)
    public ResponseEntity<ResultResponse<ReservationResponse>> createReservation(
            @RequestBody ReservationRequest reservationRequest) {
        return ResponseUtil.ok(reservationService.createReservation(reservationRequest));
    }

    @PatchMapping(RESEVATION_ID)
    public ResponseEntity<ResultResponse<Long>> createReservation(
            @PathVariable Long reservationId, @RequestBody Long memberId) throws BadRequestException {
        return ResponseUtil.ok(reservationService.cancelReservation(memberId, reservationId));
    }
}
