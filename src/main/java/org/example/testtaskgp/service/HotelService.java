package org.example.testtaskgp.service;

import org.example.testtaskgp.dto.hotel.create_update.AmenitiesDTO;
import org.example.testtaskgp.dto.hotel.create_update.HotelCreateDTO;
import org.example.testtaskgp.dto.hotel.response.HotelFullResponseDTO;
import org.example.testtaskgp.dto.hotel.response.HotelShortResponseDTO;
import org.example.testtaskgp.dto.hotel.search.HistogramParam;
import org.example.testtaskgp.dto.hotel.search.HotelSearchFilter;
import org.example.testtaskgp.entity.Address;
import org.example.testtaskgp.entity.ArrivalTime;
import org.example.testtaskgp.entity.Contacts;
import org.example.testtaskgp.entity.Hotel;
import org.example.testtaskgp.entity.enums.Amenities;
import org.example.testtaskgp.exception.HotelNotFoundException;
import org.example.testtaskgp.repository.HotelRepository;
import org.example.testtaskgp.repository.HotelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelShortResponseDTO createHotel(HotelCreateDTO dto) {

        Hotel hotel = Hotel.builder()
                .name(dto.name())
                .description(dto.description())
                .brand(dto.brand())
                .address(Address.builder()
                        .houseNumber(dto.address().houseNumber())
                        .country(dto.address().country())
                        .city(dto.address().city())
                        .street(dto.address().street())
                        .postcode(dto.address().postCode())
                        .build())
                .contacts(Contacts.builder()
                        .phone(dto.contacts().phone())
                        .email(dto.contacts().email())
                        .build())
                .arrivalTime(ArrivalTime.builder()
                        .checkIn(dto.arrivalTime().checkIn())
                        .checkOut(dto.arrivalTime().checkOut())
                        .build())
                .amenities(new ArrayList<>())
                .build();

        hotelRepository.save(hotel);

        return shortResponse(hotel);
    }

    public HotelFullResponseDTO addAmenities(Long hotel_id, AmenitiesDTO dto) {

        Hotel hotel = hotelRepository.findById(hotel_id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        for (Amenities amenities : dto.amenities()) {
            hotel.getAmenities().add(amenities);
        }

        hotelRepository.save(hotel);

        return fullResponse(hotel);
    }

    public List<HotelShortResponseDTO> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(this::shortResponse)
                .toList();
    }

    public HotelFullResponseDTO getHotelById(Long hotel_id) {
        return fullResponse(hotelRepository.findById(hotel_id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found")));
    }

    public List<HotelShortResponseDTO> search(HotelSearchFilter filter) {

        Specification<Hotel> specification = Specification
                .where(HotelSpecification.hasName(filter.name()))
                .and(HotelSpecification.hasBrand(filter.brand()))
                .and(HotelSpecification.hasCity(filter.city()))
                .and(HotelSpecification.hasCountry(filter.country()))
                .and(HotelSpecification.hasAmenities(filter.amenities()));

        return hotelRepository.findAll(specification)
                .stream()
                .map(this::shortResponse)
                .toList();
    }

    public Map<String, Long> getHistogram(HistogramParam param) {
        return switch (param) {
            case BRAND -> toMap(hotelRepository.countHotelsByBrand());
            case CITY -> toMap(hotelRepository.countHotelsByCity());
            case COUNTRY -> toMap(hotelRepository.countHotelsByCountry());
            case AMENITIES -> toMap(hotelRepository.countHotelsByAmenities());
        };
    }

    private HotelFullResponseDTO fullResponse(Hotel hotel) {
        return HotelFullResponseDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .brand(hotel.getBrand().getBrandName())
                .address(hotel.getAddress())
                .contacts(hotel.getContacts())
                .arrivalTime(hotel.getArrivalTime())
                .amenities(hotel.getAmenities()
                        .stream()
                        .map(this::amenitiesMessage)
                        .toList())
                .build();
    }

    private HotelShortResponseDTO shortResponse(Hotel hotel) {
        return HotelShortResponseDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .address(String.format(
                        "%s %s, %s, %d, %s",
                        hotel.getAddress().getHouseNumber(),
                        hotel.getAddress().getStreet(),
                        hotel.getAddress().getCity(),
                        hotel.getAddress().getPostcode(),
                        hotel.getAddress().getCountry()
                ))
                .phone(hotel.getContacts().getPhone())
                .build();
    }

    private String amenitiesMessage(Amenities amenities) {
        return amenities.getAmenities();
    }

    private Map<String, Long> toMap(List<Object[]> rows) {
        return rows.stream()
                .collect(Collectors.toMap(
                        row -> row[0].toString(),
                        row -> (Long) row[1]
                ));
    }
}
