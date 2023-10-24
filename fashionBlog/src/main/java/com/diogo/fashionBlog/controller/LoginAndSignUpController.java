package com.diogo.fashionBlog.controller;

import com.diogo.fashionBlog.dto.LoginDTO;
import com.diogo.fashionBlog.dto.SignupDTO;
import com.diogo.fashionBlog.dto.UserResponseDTO;
import com.diogo.fashionBlog.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1")

public class LoginAndSignUpController {
    private  final UserServices services;
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> registerUser (@RequestBody SignupDTO signupDTO){
        return  ResponseEntity.ok(services.registerNewUser(signupDTO));
    }
    @PostMapping("/login")
    public  ResponseEntity<UserResponseDTO> loginUser(@RequestBody LoginDTO loginDTO){
        return  ResponseEntity.ok(services.loginUser(loginDTO));
    }
    @DeleteMapping("/user/{userId}")
    public  ResponseEntity<String>  removeUser(@PathVariable Long userId){
        services.deleteUser(userId);
        return ResponseEntity.ok("user with ID:" +userId +" deleted.");
    }
}
