package com.diogo.fashionBlog.repository;

import com.diogo.fashionBlog.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
