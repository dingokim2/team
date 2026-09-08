package com.sparta.team.team.dto;

import lombok.Getter;

@Getter
public class TeamGetResponse {
    private final Long id;
    private final String name;

    public TeamGetResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
