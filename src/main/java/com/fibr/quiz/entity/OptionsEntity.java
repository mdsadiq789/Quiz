package com.fibr.quiz.entity;

import com.fibr.quiz.utils.JSONBUserType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;
import org.hibernate.annotations.TypeDef;


@Entity
@org.hibernate.annotations.TypeDef(name = "JSONBUserType", typeClass = JSONBUserType.class)
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class OptionsEntity {
    @Id
    @NotNull
    private Long id;

    @NotNull
    private Long questionId;

    @NotNull
    @Type(typw = "list-array")
    @Column(name = "booking_countries", columnDefinition = "text[]")
    private List<String> bookingCountries;
    private  answer;
}
