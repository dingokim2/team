package com.sparta.team.member.repository;

import com.sparta.team.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByTeamId(Long teamId);
}
