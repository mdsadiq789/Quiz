package com.fibr.quiz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(value = {ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessTokenQuizCreatorAuth {
}