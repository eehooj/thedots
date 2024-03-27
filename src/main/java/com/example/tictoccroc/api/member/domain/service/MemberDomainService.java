package com.example.tictoccroc.api.member.domain.service;

import com.example.tictoccroc.api.member.domain.entity.Member;
import com.example.tictoccroc.api.member.domain.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberDomainService {

    private final MemberRepository memberRepository;

    public Member get(Long id) {
        return memberRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
