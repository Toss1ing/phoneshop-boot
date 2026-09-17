package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.persistence.model.User;
import com.expertsoft.phoneshop.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByLogin(final String login) {
        return userRepository.findByLogin(login);
    }


    public User createUser(final User user) {
        return userRepository.save(user);
    }

}
