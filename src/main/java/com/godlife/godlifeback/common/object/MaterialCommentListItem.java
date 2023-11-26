package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyCommentListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialCommentListItem {
    // private int studyNumber;
    private int studyMaterialComentNumber;
    private int studyMaterialNumber;

    private String userGrade;
    private String userProfileImage;
    private String userNickName;

    // private String userEmail;
    private String studyMaterialComment;
    private String studyMaterialCommentDatetime;

    public MaterialCommentListItem(StudyCommentListResultSet resultSet){
        

        this.studyMaterialComentNumber  = resultSet.getStudyMaterialCommentNumber();
        this.studyMaterialNumber = resultSet.getStudyMaterialNumber();

        this.userGrade = resultSet.getUserGrade();
        this.userProfileImage = resultSet.getUserProfileImage();
        this.userNickName = resultSet.getNickname();

        // this.userEmail = resultSet.getUserEmail();
        this.studyMaterialComment = resultSet.getContent();
        this.studyMaterialCommentDatetime = resultSet.getWriteDatetime();
    }

    public static List<MaterialCommentListItem> getMaterialCommentList(List<StudyCommentListResultSet> resultSets){
        List<MaterialCommentListItem> list = new ArrayList<>();

        for(StudyCommentListResultSet resultSet: resultSets){
            MaterialCommentListItem materialCommentListItem = new MaterialCommentListItem(resultSet);
            list.add(materialCommentListItem);
        }

        return list;
    } 

}
