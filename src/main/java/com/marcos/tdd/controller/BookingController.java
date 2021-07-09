package com.marcos.tdd.controller;

import com.marcos.tdd.model.Booking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAllBookings() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> saveBooking(Booking booking) {
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }
}
