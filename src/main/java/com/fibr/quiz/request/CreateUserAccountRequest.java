package com.fibr.quiz.request;


import com.fibr.quiz.enums.UserType;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateUserAccountRequest {

    @NotNull
    private String userName;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private UserType userType;


}
