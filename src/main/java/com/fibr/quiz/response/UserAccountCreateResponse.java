package com.fibr.quiz.response;

import lombok.Builder;

import javax.validation.constraints.NotNull;

@Builder
public class UserAccountCreateResponse {

    @NotNull
    private String message;

    @NotNull
    private Long UserProfileId;

    @NotNull
    private String userName;

    @NotNull
    private String accessToken;
}
