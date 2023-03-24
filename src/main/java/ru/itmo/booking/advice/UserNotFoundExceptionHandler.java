package ru.itmo.booking.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itmo.booking.exception.UserNotFoundException;

@ControllerAdvice
public class UserNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    private ResponseEntity<Object> handle(UserNotFoundException exception, WebRequest request) {
        return handleExceptionInternal(exception,exception.getMessage(),
                new HttpHeaders(), HttpStatus.FORBIDDEN, request );
    }
}
