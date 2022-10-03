package com.fedag.rcrm.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String modelType, String criteria, Object value) {
        super(String.format("%s with %s: %s already exists", modelType, criteria, value));
    }
}
