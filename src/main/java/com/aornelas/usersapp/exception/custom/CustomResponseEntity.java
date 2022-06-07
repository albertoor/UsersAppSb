package com.aornelas.usersapp.exception.custom;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.List;

public class CustomResponseEntity {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    private final HttpStatus code;
    private final String message;
    private Object content;
    private List<String> errorMessages;

    public CustomResponseEntity(LocalDateTime timestamp, HttpStatus code, String message, Object content, List<String> errorMessages) {
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
        this.content = content;
        this.errorMessages = errorMessages;
    }

    public CustomResponseEntity(LocalDateTime timestamp, HttpStatus code, String message, Object content) {
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
        this.content = content;
    }


    public CustomResponseEntity(LocalDateTime timestamp, HttpStatus code, String message, List<String> errorMessages) {
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
        this.errorMessages = errorMessages;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getContent() {
        return content;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
