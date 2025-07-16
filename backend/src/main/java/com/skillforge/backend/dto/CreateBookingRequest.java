package com.skillforge.backend.dto;

import lombok.Data;

@Data
public class CreateBookingRequest {
    private Long sessionId;
    private String message;
}
