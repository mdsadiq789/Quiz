package com.fibr.quiz.repository;

import com.fibr.quiz.entity.AccessTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccessTokenRepository extends JpaRepository<AccessTokenEntity, Long> {
    Optional<AccessTokenEntity> findById(Long id);

    AccessTokenEntity findByAccessToken(String accessToken);

    boolean existsByAccessToken(String accessToken);
}
