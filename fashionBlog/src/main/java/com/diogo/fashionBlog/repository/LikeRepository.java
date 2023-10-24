package com.diogo.fashionBlog.repository;

import com.diogo.fashionBlog.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
}
