package com.godlife.godlifeback.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.godlife.godlifeback.entity.primaryKey.UserAttendanceInformationListPk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_attendance_information")
@Table(name = "user_attendance_information")
@IdClass(UserAttendanceInformationListPk.class)
public class UserAttendanceInformationEntity {
    @Id
    private int studyNumber;
    @Id
    private String userEmail;
    
    private String userAttedendanceCheck;
    private String ownerAttendanceStart;

    public UserAttendanceInformationEntity(Integer studyNumber, String email, String userAttedendanceCheck){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String resisteredWriteDatetime  = simpleDateFormat.format(now);

        this.userEmail = email;
        this.studyNumber = studyNumber;
        this.userAttedendanceCheck = userAttedendanceCheck;
        this.ownerAttendanceStart = resisteredWriteDatetime;
    }

}
