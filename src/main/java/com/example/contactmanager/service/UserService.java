package com.example.contactmanager.service;

import com.example.contactmanager.entity.User;
import com.example.contactmanager.entity.dto.UserLoginDto;
import com.example.contactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void addUser() {
        userRepository.save(new User("Anna", "Bidet", "avatar1.png", "annaB@email.com", "anna44!"));
        userRepository.save(new User("Yui", "Xang", "avatar2.jpg", "yuiX@email.com", "petitChat145"));
    }

    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    public Optional<User> createUser(String firstname, String lastname, String pictureUrl, String email, String password) {
        User newUser = new User(firstname, lastname, pictureUrl, email, password);
        return Optional.of(userRepository.save(newUser));
    }


}
