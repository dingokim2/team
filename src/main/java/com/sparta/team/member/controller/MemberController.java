package com.sparta.team.member.controller;

import com.sparta.team.member.dto.MemberCreateRequest;
import com.sparta.team.member.dto.MemberCreateResponse;
import com.sparta.team.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberController memberController;
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberCreateResponse> save(
            @RequestBody MemberCreateRequest request
    ){
        return ResponseEntity.ok(memberService.save(request));
    }
}
