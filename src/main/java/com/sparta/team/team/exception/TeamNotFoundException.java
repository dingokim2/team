package com.sparta.team.team.exception;

import com.sparta.team.common.ServiceException;
import org.springframework.http.HttpStatus;

public class TeamNotFoundException extends ServiceException {
    public TeamNotFoundException (String message){
        super(HttpStatus.NOT_FOUND, message);
    }
}
