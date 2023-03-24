package ru.itmo.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.booking.mapper.BuildingMapper;
import ru.itmo.booking.model.dto.BuildingDto;
import ru.itmo.booking.repository.BuildingRepository;
import ru.itmo.booking.service.BuildingService;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<BuildingDto> getAll() {
        return buildingMapper.buildingsToDtos(buildingRepository.getAll());
    }
}
