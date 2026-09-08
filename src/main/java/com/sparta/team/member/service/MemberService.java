package com.sparta.team.member.service;

import com.sparta.team.member.dto.*;
import com.sparta.team.member.entity.Member;
import com.sparta.team.member.exception.MemberNotFoundException;
import com.sparta.team.member.repository.MemberRepository;
import com.sparta.team.team.entity.Team;
import com.sparta.team.team.exception.TeamNotFoundException;
import com.sparta.team.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public MemberCreateResponse save(Long teamId, MemberCreateRequest request) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new TeamNotFoundException("없는 팁입니다.")
        );
        Member member = new Member(request.getName(), team);
        Member savedMember = memberRepository.save(member);
        return new MemberCreateResponse(savedMember.getId(), savedMember.getName());
    }

    @Transactional(readOnly = true)
    public List<MemberGetResponse> getAll(Long teamId) {
        if (!teamRepository.existsById(teamId)) {
            throw new TeamNotFoundException("존재하지 않는 팀입니다. id: " + teamId);
        }
        List<Member> members = memberRepository.findAllByTeamId(teamId);
        return members.stream()
                .map(member -> new MemberGetResponse(member.getId(), member.getName()))
                .toList();
    }

    @Transactional(readOnly = true)
    public MemberGetResponse getOne(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new MemberNotFoundException("없는 멤버입니다.")
        );
        return new MemberGetResponse(member.getId(), member.getName());

    }

    @Transactional
    public MemberUpdateResponse update(Long teamId, Long memberId, MemberUpdateRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new MemberNotFoundException("없는 멤버입니다.")
        );

        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new MemberNotFoundException("없는 팁입니다.")
        );

        member.changeName(request.getName());
        member.changeTeam(team);
        Member modifiedMember = memberRepository.save(member);

        return new MemberUpdateResponse(modifiedMember.getId(), modifiedMember.getName());
    }
}
