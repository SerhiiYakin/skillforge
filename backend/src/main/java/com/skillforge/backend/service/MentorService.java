package com.skillforge.backend.service;

import com.skillforge.backend.dto.MentorRequest;
import com.skillforge.backend.model.Mentor;
import com.skillforge.backend.model.User;
import com.skillforge.backend.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentorService {

    private final MentorRepository mentorRepository;

    public Mentor createMentor(MentorRequest request, User user) {
        Mentor mentor = Mentor.builder()
                .specialization(request.getSpecialization())
                .bio(request.getBio())
                .user(user)
                .build();

        return mentorRepository.save(mentor);
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }
}
