package com.skillforge.backend.dto;

import com.skillforge.backend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserProfileDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}
