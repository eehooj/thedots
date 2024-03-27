package com.example.tictoccroc.global.aop.domain.repository;


import com.example.tictoccroc.global.aop.domain.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}
