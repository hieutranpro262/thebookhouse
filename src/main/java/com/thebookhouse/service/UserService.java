package com.thebookhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebookhouse.model.User;
import com.thebookhouse.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private MailService mailService;

    public User register(User user) {
        user.setIsActive(0);
        mailService.sendUserConfirmationMail(user);
        return userRepository.save(user);
    }

    public User confirm(User user) {
        user.setIsActive(1);
        return userRepository.save(user);
    }

    public User findOne(int userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
