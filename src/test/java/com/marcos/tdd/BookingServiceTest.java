package com.marcos.tdd;

import java.time.LocalDate;
import java.util.Optional;

import com.jayway.jsonpath.Option;
import com.marcos.tdd.model.Booking;
import com.marcos.tdd.repository.BookingRepository;
import com.marcos.tdd.service.BookingService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration {
        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator() {
        String name = "Marcos Daniel";
        int days = bookingService.qtReservedDays(name);
        Assertions.assertEquals(days, 10);
    }

    @BeforeEach
    public void setup() {
        LocalDate checkIn = LocalDate.parse("2021-07-01");
        LocalDate checkOut = LocalDate.parse("2021-07-11");
        Booking booking = new Booking(1L, "Marcos Daniel", checkIn, checkOut, 2);

        Mockito.when(bookingRepository.findByReserveName(booking.getReserveName())).thenReturn(Optional.of(booking));
    }

}
