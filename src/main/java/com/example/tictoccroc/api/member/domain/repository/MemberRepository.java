package com.example.tictoccroc.api.member.domain.repository;


import com.example.tictoccroc.api.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
