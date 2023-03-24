package ru.itmo.booking.service;

import ru.itmo.booking.exception.UserAlreadyLoggedInException;
import ru.itmo.booking.exception.UserNotFoundException;
import ru.itmo.booking.model.dto.FullUserDto;
import ru.itmo.booking.model.dto.ShortUserDto;

public interface UserService {
    FullUserDto login(ShortUserDto shortUserDto) throws UserNotFoundException, UserAlreadyLoggedInException;
    boolean logout(String token) throws UserNotFoundException;
}
