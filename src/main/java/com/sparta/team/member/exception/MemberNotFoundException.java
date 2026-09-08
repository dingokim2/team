package com.sparta.team.member.exception;

import com.sparta.team.common.ServiceException;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends ServiceException {
    public MemberNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message); // HttpStatus.NOT_FOUND 지정
    }
}
