package com.marcos.tdd.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.marcos.tdd.model.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Long, Booking> {

    Optional<Booking> findByReserveName(String name);

}
