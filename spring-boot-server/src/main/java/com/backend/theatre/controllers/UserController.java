package com.backend.theatre.controllers;

import com.backend.theatre.payload.response.MessageResponse;
import com.backend.theatre.models.User;
import com.backend.theatre.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try{
            User user2 = new User();
            user2.setId(user.getId());
            user2.setUsername(user.getUsername());
            user2.setEmail(user.getEmail());
            user2.setPassword(encoder.encode(user.getPassword()));

            return ResponseEntity.ok(userService.updateUser(user2));
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Username or Email already taken"));
        }
    }
}


