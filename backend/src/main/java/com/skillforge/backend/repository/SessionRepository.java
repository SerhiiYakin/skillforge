package com.skillforge.backend.repository;

import com.skillforge.backend.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByMentorId(Long mentorId);
}
