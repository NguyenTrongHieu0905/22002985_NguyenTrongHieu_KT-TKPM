package com.iuh.fit.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingEventProducer {

    private static final String TOPIC = "booking-events";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishBookingCreated(BookingEvent event) {
        log.info("[BOOKING-SERVICE] Publishing BOOKING_CREATED event: bookingId={}, userId={}, movie='{}'",
                event.getBookingId(), event.getUserId(), event.getMovieTitle());
        kafkaTemplate.send(TOPIC, String.valueOf(event.getBookingId()), event);
        log.info("[BOOKING-SERVICE] Event published to topic '{}'", TOPIC);
    }
}
