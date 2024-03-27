package com.example.tictoccroc.api.user.dmain.repository;


import com.example.tictoccroc.api.user.dmain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
