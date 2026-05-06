package com.iuh.fit.event;

import com.iuh.fit.model.Booking;
import com.iuh.fit.model.BookingStatus;
import com.iuh.fit.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventConsumer {

    private final BookingRepository bookingRepository;

    @KafkaListener(topics = "payment-events", groupId = "booking-group",
            containerFactory = "kafkaListenerContainerFactory")
    public void handlePaymentEvent(PaymentEvent event) {
        log.info("[BOOKING-SERVICE] Received payment event: type={}, bookingId={}",
                event.getEventType(), event.getBookingId());

        bookingRepository.findById(event.getBookingId()).ifPresent(booking -> {
            if ("PAYMENT_COMPLETED".equals(event.getEventType())) {
                booking.setStatus(BookingStatus.SUCCESS);
                log.info("[BOOKING-SERVICE] Booking #{} updated to SUCCESS", booking.getId());
            } else if ("BOOKING_FAILED".equals(event.getEventType())) {
                booking.setStatus(BookingStatus.FAILED);
                log.info("[BOOKING-SERVICE] Booking #{} updated to FAILED", booking.getId());
            }
            bookingRepository.save(booking);
            log.info("[BOOKING-SERVICE] Booking #{} status saved: {}", booking.getId(), booking.getStatus());
        });
    }
}
