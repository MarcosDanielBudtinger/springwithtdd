package com.marcos.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcos.tdd.controller.BookingController;
import com.marcos.tdd.model.Booking;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllBookings() {
        try {
            mockMvc.perform(get("/bookings")).andExpect(status().isOk());
        } catch (Exception e) {
            e.getCause().toString();
        }
    }

    @Test
    public void saveBooking() {
        try {
            LocalDate checkIn = LocalDate.parse("2021-07-01");
            LocalDate checkOut = LocalDate.parse("2021-07-11");
            Booking booking = new Booking(2L, "Marcos Daniel", checkIn, checkOut, 3);

            mockMvc.perform(
                    post("/bookings").contentType("aplication/json").content(objectMapper.writeValueAsString(booking)))
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            e.getCause().getMessage().toString();
        }
    }
}
