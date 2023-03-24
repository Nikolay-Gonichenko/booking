package ru.itmo.booking.mapper;

import org.mapstruct.Mapper;
import ru.itmo.booking.model.Building;
import ru.itmo.booking.model.dto.BuildingDto;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BuildingMapper {

    BuildingDto buildingToDto(Building building);

    default List<BuildingDto> buildingsToDtos(List<Building> buildings) {
        return buildings.stream().map(this::buildingToDto).collect(Collectors.toList());
    }
}
