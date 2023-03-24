package ru.itmo.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.booking.exception.UserAlreadyLoggedInException;
import ru.itmo.booking.exception.UserNotFoundException;
import ru.itmo.booking.mapper.UserMapper;
import ru.itmo.booking.model.User;
import ru.itmo.booking.model.dto.FullUserDto;
import ru.itmo.booking.model.dto.ShortUserDto;
import ru.itmo.booking.repository.UserRepository;
import ru.itmo.booking.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public FullUserDto login(ShortUserDto shortUserDto) throws UserNotFoundException, UserAlreadyLoggedInException {
        User user = userRepository.getByIsuIdAndPassword(shortUserDto.getIsuId(), shortUserDto.getPassword())
                .orElseThrow(() -> new UserNotFoundException("Неверный логин или пароль"));
        if (user.getToken() != null && !user.getToken().equals(""))
            throw new UserAlreadyLoggedInException("Такой пользователь уже пользуется системой");

        user.setToken("token-" + shortUserDto.getIsuId());
        userRepository.save(user);
        return userMapper.userToFullDto(user);
    }

    @Override
    public boolean logout(String token) throws UserNotFoundException {
        User user = userRepository.getByToken(token)
                .orElseThrow(() -> new UserNotFoundException("Неверный токен"));
        user.setToken(null);
        userRepository.save(user);
        return true;
    }
}
