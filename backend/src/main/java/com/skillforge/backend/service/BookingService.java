package com.skillforge.backend.service;

import com.skillforge.backend.dto.CreateBookingRequest;
import com.skillforge.backend.model.Booking;
import com.skillforge.backend.model.Session;
import com.skillforge.backend.model.User;
import com.skillforge.backend.repository.BookingRepository;
import com.skillforge.backend.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SessionRepository sessionRepository;

    public Booking create(CreateBookingRequest request, User learner) {
        Session session = sessionRepository.findById(request.getSessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));

        Booking booking = Booking.builder()
                .session(session)
                .learner(learner)
                .message(request.getMessage())
                .build();

        return bookingRepository.save(booking);
    }

    public List<Booking> getMyBookings(Long learnerId) {
        return bookingRepository.findByLearnerId(learnerId);
    }

    public List<Booking> getMentorBookings(Long mentorId) {
        return bookingRepository.findBySessionMentorId(mentorId);
    }
}
