package com.example.tictoccroc.api.reservation.controller;

import com.example.tictoccroc.api.reservation.dto.request.CreateReservationRequest;
import com.example.tictoccroc.api.reservation.dto.response.ReservationResponse;
import com.example.tictoccroc.api.reservation.service.ReservationService;
import com.example.tictoccroc.global.common.dto.response.ResultResponse;
import com.example.tictoccroc.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.tictoccroc.global.util.URIUtil.RESEVATION;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(RESEVATION)
    public ResponseEntity<ResultResponse<ReservationResponse>> createReservation(
            @RequestBody CreateReservationRequest reservationRequest) {
        return ResponseUtil.ok(reservationService.createReservation(reservationRequest));
    }
}
