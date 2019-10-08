package com.udemy.rest.webservicescourse.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UserIsNullException extends RuntimeException {

    public UserIsNullException(String user_cannot_be_empty) {
    }
}
