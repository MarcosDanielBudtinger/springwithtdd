package com.marcos.tdd.service;

import java.time.Period;
import java.util.Optional;

import com.marcos.tdd.model.Booking;
import com.marcos.tdd.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public int qtReservedDays(String name) {
        Optional<Booking> booking = bookingRepository.findByReserveName(name);
        return numberOfDays(booking);
    }

    private int numberOfDays(Optional<Booking> booking) {
        return booking.isPresent() ? Period.between(booking.get().getCheckIn(), booking.get().getCheckOut()).getDays()
                : 0;
    }

}
