package com.fibr.quiz.service;

import com.fibr.quiz.entity.AccessTokenEntity;
import com.fibr.quiz.entity.UserEntity;
import com.fibr.quiz.enums.Status;
import com.fibr.quiz.exception.UserException;
import com.fibr.quiz.repository.AccessTokenRepository;
import com.fibr.quiz.repository.UserRepository;
import com.fibr.quiz.request.CreateUserAccountRequest;
import com.fibr.quiz.response.UserAccountCreateResponse;
import com.fibr.quiz.utils.Constant;
import com.fibr.quiz.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccessTokenRepository accessTokenRepository;

    @Autowired
    Utils utils;
    public ResponseEntity<?> createAccount(CreateUserAccountRequest request) throws UserException {
        String accessToken = utils.createAccessToken(request);
        if(!StringUtils.isEmpty(accessToken)){
            throw new UserException(Constant.USER_ALREADY_PRESENT);
        }

        accessTokenRepository.save(AccessTokenEntity.builder().accessToken(accessToken)
                .status(Status.ACTIVE).createdAt(new Date()).updatedAt(new Date()).build());
        UserEntity userEntity = createUserEntity(request);
        userRepository.save(userEntity);

        UserAccountCreateResponse response = UserAccountCreateResponse.builder()
                .UserProfileId(userEntity.getId()).userName(userEntity.getUserName()).message(Constant.USER_CREATED).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private UserEntity createUserEntity(CreateUserAccountRequest request) {
        String hashCode = utils.createHashCode(request.getPassword());
        return  UserEntity.builder().userName(request.getUserName())
                .email(request.getEmail()).passCode(hashCode).createdAt(new Date()).build();
    }
}
