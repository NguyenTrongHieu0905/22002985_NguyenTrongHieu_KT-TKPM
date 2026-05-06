package com.iuh.fit.service;

import com.iuh.fit.dto.BookingRequest;
import com.iuh.fit.event.BookingEvent;
import com.iuh.fit.event.BookingEventProducer;
import com.iuh.fit.model.Booking;
import com.iuh.fit.model.BookingStatus;
import com.iuh.fit.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingEventProducer bookingEventProducer;

    public Booking createBooking(BookingRequest request) {
        double totalAmount = (request.getPricePerSeat() != null ? request.getPricePerSeat() : 100000.0)
                * request.getNumberOfSeats();

        Booking booking = Booking.builder()
                .userId(request.getUserId())
                .username(request.getUsername())
                .movieId(request.getMovieId())
                .movieTitle(request.getMovieTitle())
                .numberOfSeats(request.getNumberOfSeats())
                .totalAmount(totalAmount)
                .status(BookingStatus.PENDING)
                .build();

        Booking saved = bookingRepository.save(booking);
        log.info("[BOOKING-SERVICE] Booking saved with status PENDING: bookingId={}", saved.getId());

        // Publish BOOKING_CREATED event
        BookingEvent event = BookingEvent.builder()
                .eventType("BOOKING_CREATED")
                .bookingId(saved.getId())
                .userId(saved.getUserId())
                .username(saved.getUsername())
                .movieId(saved.getMovieId())
                .movieTitle(saved.getMovieTitle())
                .numberOfSeats(saved.getNumberOfSeats())
                .totalAmount(saved.getTotalAmount())
                .timestamp(LocalDateTime.now())
                .build();

        bookingEventProducer.publishBookingCreated(event);
        return saved;
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));
    }

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
