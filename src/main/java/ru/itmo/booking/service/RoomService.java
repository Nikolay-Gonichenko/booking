package ru.itmo.booking.service;

import ru.itmo.booking.model.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> getAllByBuilding(Long buildingId);
}
