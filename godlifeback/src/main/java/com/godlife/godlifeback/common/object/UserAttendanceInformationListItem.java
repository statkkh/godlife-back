package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.entity.UserAttendanceInformationEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAttendanceInformationListItem {
    private int studyNumber;
    private String userEmail;
    private boolean userAttedencaCheck;
    private String ownerAttendanceStart;

    public UserAttendanceInformationListItem(UserAttendanceInformationEntity userAttendanceInformationEntity){
        
        this.studyNumber = userAttendanceInformationEntity.getStudyNumber();
        this.userEmail = userAttendanceInformationEntity.getUserEmail();
        this.userAttedencaCheck = true;
        this.ownerAttendanceStart = userAttendanceInformationEntity.getOwnerAttendanceStart();
    }

    public static List<UserAttendanceInformationListItem> getUserAttendanceInformationList(List<UserAttendanceInformationEntity> userAttendanceInformationEntities){
        List<UserAttendanceInformationListItem> userAttendInformationList = new ArrayList<>();
        for(UserAttendanceInformationEntity userAttendanceInformationEntity : userAttendanceInformationEntities){
            UserAttendanceInformationListItem userAttendanceInformationListItem = new UserAttendanceInformationListItem(userAttendanceInformationEntity);
            userAttendInformationList.add(userAttendanceInformationListItem);
        }
        
        return userAttendInformationList;
    }
}
