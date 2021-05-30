package com.backend.theatre.services.implementation;

import com.backend.theatre.repository.UserRepository;
import com.backend.theatre.models.User;
import com.backend.theatre.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
