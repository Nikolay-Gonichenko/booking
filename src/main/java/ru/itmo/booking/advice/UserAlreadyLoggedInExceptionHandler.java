package ru.itmo.booking.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itmo.booking.exception.UserAlreadyLoggedInException;

@ControllerAdvice
public class UserAlreadyLoggedInExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {UserAlreadyLoggedInException.class})
    private ResponseEntity<Object> handle(UserAlreadyLoggedInException exception, WebRequest request) {
        return handleExceptionInternal(exception,exception.getMessage(),
                new HttpHeaders(), HttpStatus.FORBIDDEN, request );
    }
}
