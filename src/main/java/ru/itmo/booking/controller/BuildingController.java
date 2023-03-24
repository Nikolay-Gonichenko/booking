package ru.itmo.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.booking.model.dto.BuildingDto;
import ru.itmo.booking.service.BuildingService;

import java.util.List;

@RestController
@RequestMapping("api/v1/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<BuildingDto>> getAll() {
        return ResponseEntity.ok(buildingService.getAll());
    }
}
