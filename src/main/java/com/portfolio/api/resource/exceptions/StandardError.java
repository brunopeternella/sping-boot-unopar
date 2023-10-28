package com.portfolio.api.resource.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public StandardError(){}

    public StandardError(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
