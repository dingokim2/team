package com.sparta.team.member.controller;

import com.sparta.team.member.dto.*;
import com.sparta.team.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/teams/{teamId}/members")
    public ResponseEntity<MemberCreateResponse> save(
            @PathVariable Long teamId,
            @RequestBody MemberCreateRequest request
    ){
        return ResponseEntity.ok(memberService.save(teamId, request));
    }

    @GetMapping("/teams/{teamId}/members")
    public ResponseEntity<List<MemberGetResponse>> getAll(
            @PathVariable Long teamId
    ){
        return ResponseEntity.ok(memberService.getAll(teamId));
    }

    @GetMapping("/teams/{teamId}/members/{memberId}")
    public ResponseEntity<MemberGetResponse> getOne(
            //@PathVariable Long teamId,
            @PathVariable Long memberId
    ){
        return ResponseEntity.ok(memberService.getOne(memberId));
    }

    @PutMapping("/teams/{teamId}/members/{memberId}")
    public  ResponseEntity<MemberUpdateResponse> update(
            @PathVariable Long teamId,
            @PathVariable Long memberId,
            @RequestBody MemberUpdateRequest request
    ){
        return ResponseEntity.ok(memberService.update(teamId, memberId, request));

    }
}
