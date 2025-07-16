package com.skillforge.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateSessionRequest {
    private String title;
    private String description;
    private LocalDateTime dateTime;
}
