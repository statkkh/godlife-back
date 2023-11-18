package com.godlife.godlifeback.common.object;

import com.godlife.godlifeback.entity.UserAttendanceInformationEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyAttendanceInformationListItem {
    private int studyNumber;
    private String userEmail;
    private boolean userAttedencaCheck;
    private String ownerAttendanceStart;

    public StudyAttendanceInformationListItem(UserAttendanceInformationEntity userAttendanceInformationEntity){
        
        
        
        this.studyNumber = userAttendanceInformationEntity.getStudyNumber();
        this.userEmail = userAttendanceInformationEntity.getUserEmail();
        this.userAttedencaCheck = true;
        this.ownerAttendanceStart = userAttendanceInformationEntity.getOwnerAttendanceStart();
    }
}
