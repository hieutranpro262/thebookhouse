package com.thebookhouse.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thebookhouse.exception.EntityException;
import com.thebookhouse.model.User;
import com.thebookhouse.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityException(
                    "Please fill the information correctly.", HttpStatus.BAD_REQUEST);
        }
        return userService.register(user);
    }

    @PutMapping("/confirm/{userId}")
    public User confirm(@PathVariable int userId) {
        User user = userService.findOne(userId);
        if (user == null) {
            throw new EntityException(
                    "User not found. Please check everything again.", HttpStatus.BAD_REQUEST);
        }
        return userService.confirm(user);
    }
}
