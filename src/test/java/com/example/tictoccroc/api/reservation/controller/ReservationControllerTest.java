package com.example.tictoccroc.api.reservation.controller;

import com.example.tictoccroc.api.reservation.dto.request.ReservationListRequest;
import com.example.tictoccroc.api.reservation.dto.request.ReservationRequest;
import com.example.tictoccroc.api.reservation.service.ReservationService;
import com.example.tictoccroc.global.exception.ReservationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.tictoccroc.api.reservation.enumertion.ReservationStatus.APPROVAL;
import static com.example.tictoccroc.global.util.URIUtil.RESERVATION;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
                .memberId(1L)
                .storeLectureId(2L)
                .count(3)
                .build();

        mockMvc
                .perform(
                        post(RESERVATION)
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(reservationRequest))
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 예약_실패_이미_예약() throws Exception {
        ReservationRequest reservationRequest = ReservationRequest
                .builder()
                .memberId(1L)
                .storeLectureId(2L)
                .count(3)
                .build();

        mockMvc
                .perform(
                        post(RESERVATION)
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(reservationRequest))
                )
                .andDo(print())
                .andExpect(result
                        -> assertTrue(
                                result.getResolvedException() instanceof ReservationException));
    }

    @Test
    void 예약_실패_인원수_초과() throws Exception {
        ReservationRequest reservationRequest = ReservationRequest
                .builder()
                .memberId(2L)
                .storeLectureId(1L)
                .count(3)
                .build();

        mockMvc
                .perform(
                        post(RESERVATION)
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(reservationRequest))
                )
                .andDo(print())
                .andExpect(result
                        -> assertTrue(
                        result.getResolvedException() instanceof ReservationException));
    }

    @Test
    void 예약_실패_날짜() throws Exception {
        ReservationRequest reservationRequest = ReservationRequest
                .builder()
                .memberId(2L)
                .storeLectureId(10L)
                .count(3)
                .build();

        mockMvc
                .perform(
                        post(RESERVATION)
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(reservationRequest))
                )
                .andDo(print())
                .andExpect(result
                        -> assertTrue(
                        result.getResolvedException() instanceof ReservationException));
    }

    @Test
    void 예약_취소() throws Exception {
        mockMvc
                .perform(
                        patch(RESERVATION + "/2")
                                .contentType(APPLICATION_JSON)
                                .content("2")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 매장별_예약_목록_조회() throws Exception {
        ReservationListRequest listRequest = ReservationListRequest
                .builder()
                .storeCode("S003")
                .lectureCode("L003")
                .status("APPROVAL")
                .build();
        mockMvc
                .perform(
                        get(RESERVATION)
                                .contentType(APPLICATION_JSON)
                                .flashAttr("listRequest", listRequest)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}