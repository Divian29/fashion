package com.diogo.fashionBlog.repository;

import com.diogo.fashionBlog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <UserEntity, Long>{
  boolean existsByEmail(String email);
  Optional<UserEntity> findUserEntityByEmailAndPassword(String email, String password);
}
