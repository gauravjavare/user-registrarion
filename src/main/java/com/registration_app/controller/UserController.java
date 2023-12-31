package com.registration_app.controller;

import com.registration_app.entity.User;
import com.registration_app.repository.UserRepository;
import com.registration_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepo;
    @PostMapping
    public ResponseEntity<?> createRegistration(@RequestBody User user){
        if (userRepo.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("Email Already Exists", HttpStatus.BAD_REQUEST);
        }
        if (userRepo.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>("Username Already Exists", HttpStatus.BAD_REQUEST);
        }
        User registerUser = userService.registerUser(user);
        return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }

}
