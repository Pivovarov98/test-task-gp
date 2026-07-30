package org.example.testtaskgp.controller;

import org.example.testtaskgp.dto.hotel.create_update.HotelCreateDTO;
import org.example.testtaskgp.dto.hotel.response.HotelFullResponseDTO;
import org.example.testtaskgp.dto.hotel.response.HotelShortResponseDTO;
import org.example.testtaskgp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelShortResponseDTO>> getAllHotels() {
        return ResponseEntity.ok().body(hotelService.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelFullResponseDTO> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok().body(hotelService.getHotelById(id));
    }

    @PostMapping
    public ResponseEntity<HotelShortResponseDTO> createHotel(@RequestBody HotelCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(dto));
    }
}
