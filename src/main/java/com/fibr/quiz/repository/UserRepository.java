package com.fibr.quiz.repository;

import com.fibr.quiz.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);

    UserEntity findByUserName(String userName);

    boolean existsById(Long userProfileId);

    @Query(value = "SELECT * FROM transactions WHERE gateway=?1 AND gateway_txn_id = (?2) ",
            nativeQuery = true)
    UserEntity findByUserNameAndPassCode(String userName , String hash);

    boolean existsUserName(String userName);
}
