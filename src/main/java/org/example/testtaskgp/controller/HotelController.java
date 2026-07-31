package org.example.testtaskgp.controller;

import org.example.testtaskgp.dto.hotel.create_update.AmenitiesDTO;
import org.example.testtaskgp.dto.hotel.create_update.HotelCreateDTO;
import org.example.testtaskgp.dto.hotel.response.HotelFullResponseDTO;
import org.example.testtaskgp.dto.hotel.response.HotelShortResponseDTO;
import org.example.testtaskgp.dto.hotel.search.HistogramParam;
import org.example.testtaskgp.dto.hotel.search.HotelSearchFilter;
import org.example.testtaskgp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/histogram/{param}")
    public ResponseEntity<Map<String, Long>> histogram(@PathVariable String param) {
        return ResponseEntity.ok().body(hotelService.getHistogram(HistogramParam.fromValue(param)));
    }

    @PostMapping("/hotels")
    public ResponseEntity<HotelShortResponseDTO> createHotel(@RequestBody HotelCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(dto));
    }

    @PostMapping("/hotels/{id}/amenities")
    public ResponseEntity<HotelFullResponseDTO> addAmenities(@PathVariable Long id,
                                                             @RequestBody AmenitiesDTO dto) {
        return ResponseEntity.ok().body(hotelService.addAmenities(id, dto));
    }
}
