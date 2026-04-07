package com.address.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    private String message;
    private int status;          // ← change HttpStatus to int
    private LocalDateTime timestamp;

    // ← add default no-args constructor (Jackson needs this to deserialize)
    public ErrorResponse() {
    }

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();   // ← store as int value e.g. 404, 400
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}