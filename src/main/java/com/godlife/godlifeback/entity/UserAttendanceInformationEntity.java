package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.godlife.godlifeback.entity.primaryKey.UserAttendanceInformationPk;

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
@IdClass(UserAttendanceInformationPk.class)
public class UserAttendanceInformationEntity {
    
    @Id
    private int studyNumber;
    @Id
    private String userEmail;

    String userAttendanceCheck;
    String ownerAttendanceInformation;
}
