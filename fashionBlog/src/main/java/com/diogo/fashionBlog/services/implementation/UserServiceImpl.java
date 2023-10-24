package com.diogo.fashionBlog.services.implementation;

import com.diogo.fashionBlog.dto.LoginDTO;
import com.diogo.fashionBlog.dto.SignupDTO;
import com.diogo.fashionBlog.dto.UserResponseDTO;
import com.diogo.fashionBlog.entity.UserEntity;
import com.diogo.fashionBlog.exception.DuplicateEmailException;
import com.diogo.fashionBlog.exception.PasswordMismatchException;
import com.diogo.fashionBlog.exception.WrongDetailsException;
import com.diogo.fashionBlog.repository.UserRepository;
import com.diogo.fashionBlog.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@RequiredArgsConstructor
@Service

public class UserServiceImpl implements UserServices {
    private final UserRepository userRepo;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public UserResponseDTO registerNewUser(SignupDTO signupDTO) {
        if(userRepo.existsByEmail(signupDTO.getEmail())){
            throw new DuplicateEmailException("Email already exist");
        }
        if(!signupDTO.getPassword().equals(signupDTO.getConfirmPassword())){
            throw  new PasswordMismatchException("Check password and try again.");
        }
        UserEntity newUser =  mapper.map(signupDTO, UserEntity.class);
        newUser.setRole("USER");
        UserEntity savedUser = userRepo.save(newUser);
       // UserResponseDTO responseDTO = mapper.map(savedUser, UserResponseDTO.class);
        return mapper.map(savedUser, UserResponseDTO.class);
    }


    @Override
    public UserResponseDTO loginUser(LoginDTO loginDTO) {
        UserEntity user = userRepo
                .findUserEntityByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword())
                .orElseThrow(() -> new WrongDetailsException("Email or password incorrect!"));
        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);

    }
}
