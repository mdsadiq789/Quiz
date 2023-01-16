package com.fibr.quiz.entity;

import com.fibr.quiz.enums.Category;
import com.fibr.quiz.enums.Difficulty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
public class QuestionEntity {

    @Id
    @NotNull
    private Long id;

    @NotNull
    private String question;

    @NotNull
    private Difficulty difficulty;

    @NotNull
    private Category category;
}

