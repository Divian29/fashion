package com.diogo.fashionBlog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SignupDTO {
    @NotBlank (message = "*required")
    @Size(  min =2, max = 25)
    private  String name;

    @NotBlank (message = "*required")
    @Size(  min =10, max = 25)
    private String email;

    @NotBlank(message = "*required")
    @Size(min = 4, max =15)
    private String password;

    @NotBlank(message = "*required")
    @Size(min = 4, max =15)
    private String confirmPassword;

    private String address;
}
