package com.fibr.quiz.controller;


import com.fibr.quiz.annotation.AccessTokenAuth;
import com.fibr.quiz.exception.UserException;
import com.fibr.quiz.request.CreateUserAccountRequest;
import com.fibr.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/user")
@AccessTokenAuth
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> initiateCharge(@RequestBody CreateUserAccountRequest request) throws UserException {
        return userService.createAccount(request);
    }
}
