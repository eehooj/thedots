package com.example.tictoccroc.api.reservation.dmain.repository;


import com.example.tictoccroc.api.reservation.dmain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
