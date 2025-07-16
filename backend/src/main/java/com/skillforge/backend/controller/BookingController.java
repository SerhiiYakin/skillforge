package com.skillforge.backend.controller;

import com.skillforge.backend.dto.CreateBookingRequest;
import com.skillforge.backend.model.Booking;
import com.skillforge.backend.model.User;
import com.skillforge.backend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestBody CreateBookingRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(bookingService.create(request, user));
    }

    @GetMapping("/my")
    public ResponseEntity<List<Booking>> getMyBookings(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(bookingService.getMyBookings(user.getId()));
    }

    @GetMapping("/mentor")
    public ResponseEntity<List<Booking>> getMentorBookings(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(bookingService.getMentorBookings(user.getId()));
    }
}
