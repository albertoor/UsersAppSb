package com.aornelas.usersapp.exception.handler;

import com.aornelas.usersapp.exception.NotValidUserException;
import com.aornelas.usersapp.exception.custom.CustomResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class UserRequestHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotValidUserException.class})
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request
    ) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(String.format("%s : %s", error.getField(), error.getDefaultMessage()));
        }

        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(String.format("%s : %s", error.getObjectName(), error.getDefaultMessage()));
        }

        CustomResponseEntity cre = new CustomResponseEntity(
            LocalDateTime.now(),
            badRequest,
            "There were validations errors",
            errors
        );

        return new ResponseEntity<>(cre, badRequest);
    }
}
