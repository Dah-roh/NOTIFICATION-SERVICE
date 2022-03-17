package com.reloadly_task.notificationservice.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;

    private final HttpStatus status;

    private Throwable cause;

    public CustomException(final String msg,
                           final HttpStatus httpStatus) {
        this.message = msg;
        this.status = httpStatus;
    }

    public CustomException(final String msg,
                           final Throwable actualCause,
                           final HttpStatus httpStatus) {

        this.message = msg;
        this.cause = actualCause;
        this.status = httpStatus;
    }

}
