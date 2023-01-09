package com.sergioruy.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DepartmentCodeExistException extends RuntimeException {

    public DepartmentCodeExistException(String message) {
        super(message);
    }
}
