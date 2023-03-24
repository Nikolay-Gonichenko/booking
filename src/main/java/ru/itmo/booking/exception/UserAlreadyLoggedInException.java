package ru.itmo.booking.exception;

public class UserAlreadyLoggedInException extends Exception {
    public UserAlreadyLoggedInException(String message) {
        super(message);
    }
}
