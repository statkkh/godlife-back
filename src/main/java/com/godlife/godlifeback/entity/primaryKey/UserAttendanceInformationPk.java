package com.godlife.godlifeback.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

public class UserAttendanceInformationPk implements Serializable {
    @Column(name = "study_number")
    private int studyNumber;
    @Column(name = "user_email")
    private String userEmail;    
}
