package com.diogo.fashionBlog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String email;

    private  String password;

    @Transient
    private  String confirmPassword;
    private  String role;

    private  String address;

    @OneToMany( mappedBy = "userEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostEntity> posts;

    @OneToMany ( mappedBy = "userEntity",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  List<CommentEntity> comments;

    @OneToMany ( mappedBy = "userEntity",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  List<LikeEntity> likes;

}
