package com.aornelas.usersapp.exception;

public class PhoneNumberTakenException extends RuntimeException{
    public PhoneNumberTakenException(String message) {
        super(message);
    }
}
