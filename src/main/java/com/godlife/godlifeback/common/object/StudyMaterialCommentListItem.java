package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyMaterialCommentListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyMaterialCommentListItem {
    
    private int studyMaterialCommentNumber;
    private int studyMaterialNumber;

    private String userEmail;
    private String studyGrade;
    
    private String userProfilImage;
    private String userNickName;

    private String studyMaterialCommentContent;
    private String studyMaterialCommentDatetime;

    public StudyMaterialCommentListItem(StudyMaterialCommentListResultSet resultSet) {   
        this.studyMaterialCommentNumber = resultSet.getStudyMaterialCommentNumber();
        this.studyMaterialNumber = resultSet.getStudyMaterialNumber();
        this.userEmail = resultSet.getUserEmail();
        this.studyGrade = resultSet.getStudyGrade();
        this.userProfilImage = resultSet.getUserProfileImage();
        this.userNickName = resultSet.getUserNickName();
        this.studyMaterialCommentContent = resultSet.getStudyMaterialCommentContent();
        this.studyMaterialCommentDatetime = resultSet.getStudyMaterialCommentDatetime();
    }

    public static List<StudyMaterialCommentListItem> getStudyMaterialCommentList(List<StudyMaterialCommentListResultSet> resultSets) {
        List<StudyMaterialCommentListItem> materialCommentList = new ArrayList<>();
        for (StudyMaterialCommentListResultSet resultSet : resultSets) {
            StudyMaterialCommentListItem studyMaterialCommentListItem = new StudyMaterialCommentListItem(resultSet);
            materialCommentList.add(studyMaterialCommentListItem);
        }
        return materialCommentList;
    }
}
