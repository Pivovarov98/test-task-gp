package org.example.testtaskgp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.testtaskgp.service.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(HotelController.class)
class HotelControllerTest {

    @MockitoBean
    private HotelService hotelService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllHotels() {
    }

    @Test
    void getHotelById() {
    }

    @Test
    void search() {
    }

    @Test
    void histogram() {
    }

    @Test
    void createHotel() {
    }

    @Test
    void addAmenities() {
    }
}