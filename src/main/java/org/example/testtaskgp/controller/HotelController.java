package org.example.testtaskgp.controller;

import org.example.testtaskgp.dto.hotel.create_update.HotelCreateDTO;
import org.example.testtaskgp.dto.hotel.response.HotelFullResponseDTO;
import org.example.testtaskgp.dto.hotel.response.HotelShortResponseDTO;
import org.example.testtaskgp.dto.hotel.search.HotelSearchFilter;
import org.example.testtaskgp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelShortResponseDTO>> getAllHotels() {
        return ResponseEntity.ok().body(hotelService.getAllHotels());
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<HotelFullResponseDTO> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok().body(hotelService.getHotelById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<HotelShortResponseDTO>> search(HotelSearchFilter filter) {
        return ResponseEntity.ok().body(hotelService.search(filter));
    }

    @PostMapping("/hotels")
    public ResponseEntity<HotelShortResponseDTO> createHotel(@RequestBody HotelCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(dto));
    }
}
