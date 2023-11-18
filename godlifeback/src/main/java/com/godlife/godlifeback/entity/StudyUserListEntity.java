package com.godlife.godlifeback.entity;

import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "study_user_list")
@Table(name = "study_user_list")
public class StudyUserListEntity {
    
    private int studyNumber;
    private String studyUserEmail;
    private String studyGrade;

    public StudyUserListEntity(Integer studyNumber,String email ,String studyGrade){

        this.studyNumber = studyNumber;
        this.studyUserEmail = email;
        this.studyGrade = studyGrade;
    }
}    
