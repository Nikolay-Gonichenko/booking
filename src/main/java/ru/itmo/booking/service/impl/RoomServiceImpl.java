package ru.itmo.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.booking.mapper.RoomMapper;
import ru.itmo.booking.model.dto.RoomDto;
import ru.itmo.booking.repository.RoomRepository;
import ru.itmo.booking.service.RoomService;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<RoomDto> getAllByBuilding(Long buildingId) {
        return roomMapper.roomsToDtos(roomRepository.getAllByBuildingId(buildingId));
    }
}
