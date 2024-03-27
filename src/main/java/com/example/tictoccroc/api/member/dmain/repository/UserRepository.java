package com.example.tictoccroc.api.member.dmain.repository;


import com.example.tictoccroc.api.member.dmain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Long> {

}
