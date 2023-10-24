package com.diogo.fashionBlog.services;

import com.diogo.fashionBlog.dto.LoginDTO;
import com.diogo.fashionBlog.dto.SignupDTO;
import com.diogo.fashionBlog.dto.UserResponseDTO;

public interface UserServices {
    UserResponseDTO registerNewUser (SignupDTO signupDTO);
    UserResponseDTO loginUser(LoginDTO loginDTO);
    void deleteUser(Long userId);
}
