package com.skillforge.backend.controller;

import com.skillforge.backend.dto.CreateSessionRequest;
import com.skillforge.backend.model.Session;
import com.skillforge.backend.model.User;
import com.skillforge.backend.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<Session> createSession(
            @RequestBody CreateSessionRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(sessionService.create(request, user));
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAll());
    }

    @GetMapping("/my")
    public ResponseEntity<List<Session>> getMySessions(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(sessionService.getByMentorId(user.getId()));
    }
}
