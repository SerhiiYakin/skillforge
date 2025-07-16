package com.skillforge.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MentorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String skills;
    private Integer yearsOfExperience;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
