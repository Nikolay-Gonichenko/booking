package ru.itmo.booking.mapper;

import org.mapstruct.Mapper;
import ru.itmo.booking.model.Role;
import ru.itmo.booking.model.dto.RoleDto;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto roleToRoleDto(Role role);
}
