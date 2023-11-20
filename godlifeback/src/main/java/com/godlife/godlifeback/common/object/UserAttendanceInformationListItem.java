package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyCommentListResultSet;
import com.godlife.godlifeback.repository.resultSet.UserAttendanceInformationResultset;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAttendanceInformationListItem {
    private int studyNumber;
    private String userEmail;
    private String userGrade;
    private String userProfileImage;
    private String userNickName;
    private String userAttendanceCheck;
    private String ownerAttendanceStart;

    public UserAttendanceInformationListItem(StudyCommentListResultSet resultSet){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String resisteredWriteDatetime = simpleDateFormat.format(now);

        this.studyNumber = resultSet.getStudyNumber();
        this.userEmail = resultSet.getUserEmail(); 
        this.userGrade = resultSet.getUserGrade();  
        this.userProfileImage = resultSet.getProfileImage();

        this.userNickName = resultSet.getNickname();
        this.ownerAttendanceStart = resisteredWriteDatetime;
    }

    public static List<UserAttendanceInformationListItem> getUserAttendanceInformationList(List<StudyCommentListResultSet> resultSets){
        List<UserAttendanceInformationListItem> userAttendInformationList = new ArrayList<>();
        for(StudyCommentListResultSet resultSet : resultSets){
            UserAttendanceInformationListItem userAttendanceInformationListItem = new UserAttendanceInformationListItem(resultSet);
            userAttendInformationList.add(userAttendanceInformationListItem);
        }
        return userAttendInformationList;
    }
}
