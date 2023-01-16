package com.fibr.quiz.repository;

import com.fibr.quiz.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

public class userRepo {

    @Autowired
    private UserRepository userRepository;

}
