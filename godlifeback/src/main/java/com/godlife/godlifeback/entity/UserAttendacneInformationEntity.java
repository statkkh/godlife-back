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
@Entity(name = "user_attendance_information")
@Table(name = "user_attendance_information")
public class UserAttendacneInformationEntity {
    
    private int studyNumber;
    private String userEmail;
    private boolean userAttedencaCheck;
    private String ownerAttendanceStart;

}
