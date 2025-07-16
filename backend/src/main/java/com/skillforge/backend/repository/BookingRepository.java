package com.skillforge.backend.repository;

import com.skillforge.backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByLearnerId(Long learnerId);
    List<Booking> findBySessionMentorId(Long mentorId);
}
