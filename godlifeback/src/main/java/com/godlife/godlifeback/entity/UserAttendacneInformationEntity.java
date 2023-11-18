package com.godlife.godlifeback.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_attendance_information")
@Table(name = "user_attendance_information")
public class UserAttendacneInformationEntity {
    
    private int studyNumber;
    private String userEmail;
    private boolean userAttedencaCheck;
    private String ownerAttendanceStart;

    public UserAttendacneInformationEntity(Integer studyNumber, String email){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String writeDatetime  = simpleDateFormat.format(now);

        this.userEmail = email;
        this.studyNumber = studyNumber;
        this.userAttedencaCheck = true;
        this.ownerAttendanceStart = writeDatetime;

    }

}
