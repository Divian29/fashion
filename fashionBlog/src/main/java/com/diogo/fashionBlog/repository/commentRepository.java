package com.diogo.fashionBlog.repository;

import com.diogo.fashionBlog.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentRepository extends JpaRepository<CommentEntity, Long> {

}
