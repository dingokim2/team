package com.sparta.team.member.dto;

import lombok.Getter;

@Getter
public class MemberUpdateResponse {
    private final Long id;
    private final String name;

    public MemberUpdateResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
