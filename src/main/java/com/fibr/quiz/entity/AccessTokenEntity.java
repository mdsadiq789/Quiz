package com.fibr.quiz.entity;

import com.fibr.quiz.enums.Status;
import lombok.Builder;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Builder
@Setter
public class AccessTokenEntity {

    @Id
    @NotNull
    @Column(nullable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String accessToken;

    @NotNull
    @Column(nullable = false)
    private Status status;

    @NotNull
    @Column(nullable = false)
    private Date createdAt;

    @NotNull
    @Column(nullable = false)
    private Date updatedAt;

}
