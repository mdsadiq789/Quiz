package com.fibr.quiz.controller;


import com.fibr.quiz.annotation.AccessTokenAuth;
import com.fibr.quiz.exception.UserException;
import com.fibr.quiz.interceptor.RequestInterceptor;
import com.fibr.quiz.request.CreateUserAccountRequest;
import com.fibr.quiz.request.LoginRequest;
import com.fibr.quiz.service.UserService;
import com.fibr.quiz.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/user")

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createAccount")
    @AccessTokenAuth
    public ResponseEntity<?> createAccount(@RequestBody CreateUserAccountRequest request) throws UserException {
        return userService.createAccount(request);
    }

    @PostMapping("/loginAccount")
    public ResponseEntity<?> logoutUser(@RequestBody LoginRequest request) throws UserException {
        return userService.loginAccount(request);
    }

    @PutMapping("/logoutAccount")
    public ResponseEntity<?> logoutUser() throws UserException {
        String accessToken = RequestInterceptor.getHeader(Constant.ACCESS_TOKEN);
        return userService.logoutAccount(accessToken);
    }
}
