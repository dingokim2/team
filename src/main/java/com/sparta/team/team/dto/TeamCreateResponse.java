package com.sparta.team.team.dto;

import lombok.Getter;

@Getter
public class TeamCreateResponse {
    private final Long id;
    private final String name;

    public TeamCreateResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
