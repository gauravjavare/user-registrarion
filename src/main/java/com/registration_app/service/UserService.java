package com.registration_app.service;

import com.registration_app.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

     User registerUser(User user);

}
