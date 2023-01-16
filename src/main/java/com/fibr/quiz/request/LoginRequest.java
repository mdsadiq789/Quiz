package com.fibr.quiz.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class LoginRequest {

    @NotNull
    private String userName;

    @NotNull
    private String password;

}
