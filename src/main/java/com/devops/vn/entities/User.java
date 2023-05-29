package com.devops.vn.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
    
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
