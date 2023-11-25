package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "study")
@Table(name = "study")
public class StudyEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyNumber;
    private String studyName;
    private String studyStartDate;
    private String studyEndDate;
    private String studyPersonal;
    private String studyCategory1;
    private String studyCategory2;
    private String studyCategory3;
    private Boolean studyPublicCheck;
    private String studyPrivatePassword;
    private String studyCoverImageUrl;
    private String StudyNextStartDatetime;
    private String StudyNextEndDatetime;
    @NotNull
    private int studyTotalDay;
    private String createStudyUserEmail;
}
