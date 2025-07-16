package com.skillforge.backend.controller;

import com.skillforge.backend.dto.MentorRequest;
import com.skillforge.backend.model.Mentor;
import com.skillforge.backend.model.User;
import com.skillforge.backend.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentors")
@RequiredArgsConstructor
public class MentorController {

    private final MentorService mentorService;

    @PostMapping
    public ResponseEntity<Mentor> createMentor(@RequestBody MentorRequest request, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(mentorService.createMentor(request, user));
    }

    @GetMapping
    public ResponseEntity<List<Mentor>> getAllMentors() {
        return ResponseEntity.ok(mentorService.getAllMentors());
    }
}