package ru.itmo.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.booking.model.dto.RoomDto;
import ru.itmo.booking.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<List<RoomDto>> getAllByBuilding(@RequestBody Long buildingId) {
        return ResponseEntity.ok(roomService.getAllByBuilding(buildingId));
    }
}
