package com.fibr.quiz.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
public class AnswerEntity {

    @Id
    @NotNull
    private Long id;

    @NotNull
    private Long questionId;

    @NotNull
    private String answer;
}
