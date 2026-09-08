package com.sparta.team.team.service;

import com.sparta.team.team.dto.TeamCreateRequest;
import com.sparta.team.team.dto.TeamCreateResponse;
import com.sparta.team.team.dto.TeamGetResponse;
import com.sparta.team.team.entity.Team;
import com.sparta.team.team.exception.TeamNotFoundException;
import com.sparta.team.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    @Transactional
    public TeamCreateResponse save(TeamCreateRequest request) {
        Team team = new Team(request.getName());
        Team savedTeam = teamRepository.save(team);
        return new TeamCreateResponse(
                savedTeam.getId(),
                savedTeam.getName()
        );
    }

    @Transactional(readOnly = true)
    public List<TeamGetResponse> getAll() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(team -> new TeamGetResponse(team.getId(), team.getName()))
                .toList();
    }

    @Transactional(readOnly = true)
    public TeamGetResponse getOne(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new TeamNotFoundException("없는 팀입니다.")
                );
        return new TeamGetResponse(team.getId(), team.getName());
    }
}
