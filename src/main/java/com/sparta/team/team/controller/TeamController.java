package com.sparta.team.team.controller;

import com.sparta.team.team.dto.TeamCreateRequest;
import com.sparta.team.team.dto.TeamCreateResponse;
import com.sparta.team.team.dto.TeamGetResponse;
import com.sparta.team.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private TeamService teamService;

    @PostMapping("/teams")
    public ResponseEntity<TeamCreateResponse> save(
            @RequestBody TeamCreateRequest request
            ){

        return ResponseEntity.ok(teamService.save(request));
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamGetResponse>> getAll(){
        return ResponseEntity.ok(teamService.getAll());
    }

    @GetMapping("/teams/{teamId}")
    public ResponseEntity<TeamGetResponse> getOne(
            @PathVariable Long teamId
    ){
        return ResponseEntity.ok(teamService.getOne(teamId));
    }
}
