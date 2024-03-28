package com.example.tictoccroc.api.reservation.controller;

import com.example.tictoccroc.api.reservation.dto.request.ReservationRequest;
import com.example.tictoccroc.api.reservation.service.ReservationService;
import com.example.tictoccroc.global.exception.AlreadyReservationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.tictoccroc.global.util.URIUtil.RESEVATION;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReservationService reservationService;

    @Test
    void 예약_성공() throws Exception {
        ReservationRequest reservationRequest = ReservationRequest
                .builder()
                .memberId(2L)
                .storeLectureId(2L)
                .build();

        mockMvc
                .perform(
                        post(RESEVATION)
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(reservationRequest))
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 예약_실패() throws Exception {
        ReservationRequest reservationRequest = ReservationRequest
                .builder()
                .memberId(1L)
                .storeLectureId(1L)
                .build();

        mockMvc
                .perform(
                        post(RESEVATION)
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(reservationRequest))
                )
                .andDo(print())
                .andExpect(result
                        -> assertTrue(
                                result.getResolvedException() instanceof AlreadyReservationException));
    }

    @Test
    void 예약_취소() throws Exception {
        mockMvc
                .perform(
                        patch(RESEVATION + "/1")
                                .contentType(APPLICATION_JSON)
                                .content("1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}