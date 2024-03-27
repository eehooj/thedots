package com.example.tictoccroc.api.reservation.dmain.repository;


import com.example.tictoccroc.api.reservation.dmain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
