package com.example.tictoccroc.api.reservation.domain.repository;


import com.example.tictoccroc.api.reservation.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
