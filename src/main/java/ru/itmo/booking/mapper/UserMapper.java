package ru.itmo.booking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.booking.model.User;
import ru.itmo.booking.model.dto.FullUserDto;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    @Mapping(source = "role", target = "roleDto")
    FullUserDto userToFullDto(User user);
}
