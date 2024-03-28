package com.example.tictoccroc.api.reservation.domain.repository;


import com.example.tictoccroc.api.reservation.domain.entity.Reservation;
import com.example.tictoccroc.api.reservation.domain.repository.custom.ReservationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationRepositoryCustom {

}
