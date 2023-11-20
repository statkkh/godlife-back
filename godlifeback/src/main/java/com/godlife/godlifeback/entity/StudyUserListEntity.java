package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.godlife.godlifeback.entity.primaryKey.StudyUserListPK;

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
@IdClass(StudyUserListPK.class)
public class StudyUserListEntity {
    
    @Id
    private int studyNumber;
    @Id
    private String userEmail;
    
    private String studyGrade;

    public StudyUserListEntity(Integer studyNumber,String email ,String studyGrade){

        this.studyNumber = studyNumber;
        this.userEmail = email;
        this.studyGrade = studyGrade;
    }

    
}    
