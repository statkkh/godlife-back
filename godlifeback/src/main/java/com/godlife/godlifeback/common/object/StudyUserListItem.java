package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.entity.StudyUserListEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyUserListItem {
    private int studyNumber;   
    private String studyUserEmail;
    private String studyGrade;

    public StudyUserListItem(StudyUserListEntity studyUserListEntity){
        this.studyNumber = studyUserListEntity.getStudyNumber();
        this.studyUserEmail = studyUserListEntity.getUserEmail();
        this.studyGrade = studyUserListEntity.getStudyGrade();
    }

    public static List<StudyUserListItem> getUserList(List<StudyUserListEntity> studyUserListEntities){
        List<StudyUserListItem> userList = new ArrayList<>();
        for(StudyUserListEntity studyUserListEntity : studyUserListEntities){
            StudyUserListItem studyUserListItem = new StudyUserListItem(studyUserListEntity);
            userList.add(studyUserListItem);
        }
        return userList;
    }
}
