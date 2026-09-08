package com.sparta.team.member.service;

import com.sparta.team.member.dto.MemberCreateRequest;
import com.sparta.team.member.dto.MemberCreateResponse;
import com.sparta.team.member.entity.Member;
import com.sparta.team.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse save(MemberCreateRequest request) {
        Member member = new Member(request.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberCreateResponse(savedMember.getId(), savedMember.getName());
    }
}
