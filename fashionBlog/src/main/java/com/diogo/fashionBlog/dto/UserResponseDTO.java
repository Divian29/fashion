package com.diogo.fashionBlog.dto;

import jakarta.persistence.Transient;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserResponseDTO {
    private Long userId;

    private String name;

    private String email;

    private  String password;

    private  String role;

    private  String address;
}
