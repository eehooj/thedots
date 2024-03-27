package com.example.tictoccroc.api.reservation.domain.repository;


import com.example.tictoccroc.api.reservation.domain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
