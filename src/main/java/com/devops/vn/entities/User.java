package com.devops.vn.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long userId;

    @Column (name = "avatar")
    private String avatar;

    @Column (name = "name")
    private String name;

    @Column (name = "username")
    private String username;

    @Column (name = "password")
    private String password;

}
