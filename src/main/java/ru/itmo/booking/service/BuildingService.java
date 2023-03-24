package ru.itmo.booking.service;

import ru.itmo.booking.model.dto.BuildingDto;

import java.util.List;

public interface BuildingService {
    List<BuildingDto> getAll();
}
