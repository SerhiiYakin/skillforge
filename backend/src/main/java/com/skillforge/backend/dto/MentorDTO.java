package com.skillforge.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorDTO {
    private Long id;
    private String fullName;
    private String bio;
    private String specialization;
}
