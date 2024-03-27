package com.example.tictoccroc.api.reservation.domain.service;

import com.example.tictoccroc.api.reservation.domain.entity.Reservation;
import com.example.tictoccroc.api.reservation.domain.entity.StoreLecture;
import com.example.tictoccroc.api.reservation.domain.repository.LectureRepository;
import com.example.tictoccroc.api.reservation.domain.repository.ReservationRepository;
import com.example.tictoccroc.api.reservation.domain.repository.StoreLectureRepository;
import com.example.tictoccroc.api.reservation.domain.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ReservationDomainService {

    private final LectureRepository lectureRepository;
    private final ReservationRepository reservationRepository;
    private final StoreRepository storeRepository;
    private final StoreLectureRepository storeLectureRepository;

    public boolean isAlreadyReservation(Long memberId, Long storeLectureId) {
        return reservationRepository.isAlreadyReservation(memberId, storeLectureId);
    }

    public StoreLecture get(Long storeLectureId) {
        return storeLectureRepository
                .findById(storeLectureId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
