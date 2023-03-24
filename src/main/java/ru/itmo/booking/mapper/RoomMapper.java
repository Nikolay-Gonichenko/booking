package ru.itmo.booking.mapper;

import org.mapstruct.Mapper;
import ru.itmo.booking.model.Building;
import ru.itmo.booking.model.Room;
import ru.itmo.booking.model.dto.BuildingDto;
import ru.itmo.booking.model.dto.RoomDto;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto roomToDto(Room room);

    default List<RoomDto> roomsToDtos(List<Room> rooms) {
        return rooms.stream().map(this::roomToDto).collect(Collectors.toList());
    }
}
