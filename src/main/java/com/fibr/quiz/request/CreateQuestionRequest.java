package com.fibr.quiz.request;

import javax.validation.constraints.NotNull;

import com.fibr.quiz.enums.Category;
import com.fibr.quiz.enums.Difficulty;
import org.json.simple.JSONObject;

public class CreateQuestionRequest {

    @NotNull
    private String question;

    @NotNull
    private JSONObject options;

    @NotNull
    private String answer;

    @NotNull
    private Category category;

    @NotNull
    private Difficulty difficulty;
}
