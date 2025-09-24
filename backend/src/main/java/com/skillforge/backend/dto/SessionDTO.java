package com.skillforge.backend.dto;

import com.skillforge.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private Long mentorId;
    private String mentorName;
}
