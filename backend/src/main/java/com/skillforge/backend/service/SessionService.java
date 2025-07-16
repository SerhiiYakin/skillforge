package com.skillforge.backend.service;

import com.skillforge.backend.dto.CreateSessionRequest;
import com.skillforge.backend.model.Session;
import com.skillforge.backend.model.User;
import com.skillforge.backend.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public Session create(CreateSessionRequest req, User mentor) {
        Session session = Session.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .dateTime(req.getDateTime())
                .mentor(mentor)
                .build();

        return sessionRepository.save(session);
    }

    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    public List<Session> getByMentorId(Long id) {
        return sessionRepository.findByMentorId(id);
    }
}
