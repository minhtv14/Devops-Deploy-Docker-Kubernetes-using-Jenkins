package com.devops.vn.controllers;

import java.util.List;

import com.devops.vn.entities.User;
import com.devops.vn.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin ("*")
public class WelcomeController {

    @Autowired
    private UserService userService;

    @GetMapping ("/")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<String>("Wecome Spring Boot 3 & Spring Framework 6!", HttpStatus.OK);
    }

    @GetMapping ("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }

}
