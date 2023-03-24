package ru.itmo.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.booking.exception.UserAlreadyLoggedInException;
import ru.itmo.booking.exception.UserNotFoundException;
import ru.itmo.booking.model.dto.FullUserDto;
import ru.itmo.booking.model.dto.ShortUserDto;
import ru.itmo.booking.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("login")
    public ResponseEntity<FullUserDto> login(@RequestBody ShortUserDto shortUserDto) throws UserNotFoundException, UserAlreadyLoggedInException {
        return ResponseEntity.ok(userService.login(shortUserDto));
    }

    @CrossOrigin
    @PostMapping("logout")
    public ResponseEntity<Boolean> logout(@RequestBody String token) throws UserNotFoundException {
        return ResponseEntity.ok(userService.logout(token));
    }
}
