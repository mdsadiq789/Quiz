package com.fibr.quiz.controller;


import com.fibr.quiz.annotation.AccessTokenAuth;
import com.fibr.quiz.annotation.AccessTokenQuizCreatorAuth;
import com.fibr.quiz.exception.UserException;
import com.fibr.quiz.interceptor.RequestInterceptor;
import com.fibr.quiz.request.CreateQuestionRequest;
import com.fibr.quiz.request.CreateUserAccountRequest;
import com.fibr.quiz.request.LoginRequest;
import com.fibr.quiz.service.QAService;
import com.fibr.quiz.service.UserService;
import com.fibr.quiz.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/question")
@AccessTokenQuizCreatorAuth
public class QAController {

    @Autowired
    QAService qaService;

    @PostMapping("/create")
    @AccessTokenAuth
    public ResponseEntity<?> createQuestion(@RequestBody CreateQuestionRequest request) throws UserException {
        return qaService.createQuestion(request);
    }

    @PatchMapping("/updateQ")
    public ResponseEntity<?> updateQuestion(@RequestBody LoginRequest request) throws UserException {
        return qaService.loginAccount(request);
    }

    @PutMapping("/logoutAccount")
    public ResponseEntity<?> logoutUser() throws UserException {
        String accessToken = RequestInterceptor.getHeader(Constant.ACCESS_TOKEN);
        return userService.logoutAccount(accessToken);
    }
}
